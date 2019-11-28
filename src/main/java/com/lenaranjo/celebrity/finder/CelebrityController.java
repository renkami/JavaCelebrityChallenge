package com.lenaranjo.celebrity.finder;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.lenaranjo.celebrity.util.CSVTeamReader;
import org.apache.commons.lang3.ArrayUtils;

import com.lenaranjo.celebrity.model.Person;
import com.lenaranjo.celebrity.model.Team;
import com.opencsv.CSVReader;

public class CelebrityController {

	public static final String file = "src/main/resources/team.csv";

	public static void main(String[] args) {
		Team team = new Team();
		try {
			team.setTeamList(CSVTeamReader.readTeam(file));
			Person celebrity = team.findCelebrity();
			if(celebrity == null){
				System.out.println("There is no celebrity on the team");
			}else {
				System.out.println("There is a celebrity: "+celebrity);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
