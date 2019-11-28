package com.lenaranjo.celebrity.finder;

import static com.lenaranjo.celebrity.util.CSVTeamReader.readTeam;
import static org.junit.jupiter.api.Assertions.*;

import com.lenaranjo.celebrity.model.Person;
import com.lenaranjo.celebrity.model.Team;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CelebrityTest {
    private final static String baseURL = "src/main/resources/";
    private final static Integer celebrityId = 5;
    private final static Person celebrity = new Person(celebrityId);

    @Test
    @DisplayName("Find celebrity")
    void findCelebrity(){
        try {
            Team team = new Team(readTeam(baseURL+"team.csv"));
            Person person = team.findCelebrity();

            assertNotNull(person, "There is no celebrity among the team");
            assertEquals(person, celebrity, "The celebrity found is not the expected one");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("No team")
    void noTeam(){
        try {
            Team team = new Team(readTeam(baseURL+"noTeam.csv"));
            Person person = team.findCelebrity();

            assertNull(person, "There is a celebrity among the team");
            assertEquals(0, team.getTeamList().size(), "TThe are members on the team list");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Two team members who doesn't know anyone")
    void team2(){
        try {
            Team team = new Team(readTeam(baseURL+"team2.csv"));
            Person person = team.findCelebrity();

            assertNull(person, "There is a celebrity among the team");
            assertTrue(team.getTeamList().size()>0, "There are no team members");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("No celebrity on the team")
    void noCelebrity(){
        try {
            Team team = new Team(readTeam(baseURL+"teamNoCelebrity.csv"));
            Person person = team.findCelebrity();

            assertNull(person, "There is a celebrity among the team");
            assertTrue(team.getTeamList().size()>0, "There are no team members");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Only one celebrity")
    void oneMember(){
        try {
            Team team = new Team(readTeam(baseURL+"teamOnlyCelebrity.csv"));
            Person person = team.findCelebrity();

            assertNotNull(person, "There is no celebrity among the team");
            assertEquals(person, celebrity, "The celebrity found is not the expected one");
            assertTrue(team.getTeamList().size()==1, "There are other team members");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
