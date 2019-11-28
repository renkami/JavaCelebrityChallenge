package com.lenaranjo.celebrity.util;

import com.lenaranjo.celebrity.model.Person;
import com.opencsv.CSVReader;
import org.apache.commons.lang3.ArrayUtils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVTeamReader {
    public static List<Person> readTeam(String file) throws IOException, Exception{
        String[] row;
        CSVReader csvReader = new CSVReader(new FileReader(file));
        List<Person> team = new ArrayList<Person>();

        while ((row = csvReader.readNext()) != null) {
            if (row[0].chars().allMatch(Character::isDigit)) {
                Person person;
                if (row.length > 2 && row[2].length() > 0) {
                    List<Integer> knows = Arrays.asList(ArrayUtils
                            .toObject(Arrays.stream(row[2].split(",")).mapToInt(Integer::parseInt).toArray()));
                    person = (new Person(Integer.parseInt(row[0]), row[1], knows));
                } else {
                    person = (new Person(Integer.parseInt(row[0]), row[1]));
                }
                team.add(person);
            }
        }
        return team;
    }
}
