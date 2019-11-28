package com.lenaranjo.celebrity.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

//3216089594
//3104296111
// 3002997841
@Data

public class Team {
	private List<Person> teamList;

	private Person celebrity;

	private boolean isNoCelebrity;

    public Team() {
        super();
        teamList = new ArrayList<Person>();
    }
    public Team(List<Person> teamList) {
        super();
        this.teamList = teamList;
    }

	public boolean addPerson(Person newPerson) {
		return teamList.add(newPerson);
	}

	public Person findCelebrity() {
		isNoCelebrity = true;
		celebrity = null;

		isNoCelebrity = teamList.stream().anyMatch(person -> {
			if (person.getKnowns() == null) {
				if (celebrity == null) {
					celebrity = person;
					isNoCelebrity =false;
				} else {
				    celebrity = null;
					return true;
				}
			}
			return false;
		});
		if (celebrity != null  && !isNoCelebrity) {
			isNoCelebrity = teamList.stream().anyMatch(
					person -> (person.getId() != celebrity.getId() && !person.getKnowns().contains(celebrity.getId())));
		}
		return celebrity;


	}

}
