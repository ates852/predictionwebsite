package com.alex.prediction.core;

import com.alex.prediction.models.*;

import java.util.List;

public class Core {
    List<UserTeam> userTeams;
    List<Team> teams;
    List<Scorer> scorers;
    List<UserScorer> userScorers;
    List<Assist> assists;
    List<UserAssist> userAssists;
    List<CleanSheet> cleanSheets;
    List<UserCleanSheet> userCleanSheets;


    protected int result = 0;

    public Core(List<UserTeam> userTeams,
                List<Team> teams,
                List<Scorer> scorers,
                List<UserScorer> userScorers,
                List<Assist> assists,
                List<UserAssist> userAssists,
                List<CleanSheet> cleanSheets,
                List<UserCleanSheet> userCleanSheets) {
        this.userTeams = userTeams;
        this.teams = teams;
        this.scorers = scorers;
        this.userScorers = userScorers;
        this.assists = assists;
        this.userAssists = userAssists;
        this.cleanSheets = cleanSheets;
        this.userCleanSheets = userCleanSheets;
        calculateStandings();
        System.out.println("standings"+result);
        calculateTopScorer();
        System.out.println("standings"+result);
        calculateTopAssist();
        System.out.println("standings"+result);
        calculateTopCleanSheet();
    }

    public void calculateStandings() {
        for (int i = 0; i < userTeams.size(); i++) {
            String usersStandingName = userTeams.get(i).getNameOfTeam();
            if (usersStandingName.equalsIgnoreCase(teams.get(i).getTeamName())) {
                result += 20;
                continue;
            }
            if (i - 1 >= 0 && usersStandingName.equalsIgnoreCase(teams.get(i - 1).getTeamName())) {
                result += 15;
                continue;
            }
            if (i + 1 < 20 && usersStandingName.equalsIgnoreCase(teams.get(i + 1).getTeamName())) {
                result += 15;
                continue;
            }
            if (i - 2 >= 0 && usersStandingName.equalsIgnoreCase(teams.get(i - 2).getTeamName())) {
                result += 10;
                continue;
            }
            if (i + 2 < 20 && usersStandingName.equalsIgnoreCase(teams.get(i + 2).getTeamName())) {
                result += 10;
                continue;
            }
            if (i - 3 >= 0 && usersStandingName.equalsIgnoreCase(teams.get(i - 3).getTeamName())) {
                result += 5;
                continue;
            }
            if (i + 3 < 20 && usersStandingName.equalsIgnoreCase(teams.get(i + 3).getTeamName())) {
                result += 5;
            }
        }
    }

    public void calculateTopScorer() {
        for (int i = 0; i < 3; i++) {
            String usersPlayerName = userScorers.get(i).getNameOfPlayer();
            for (int x = 0; x < 3; x++) {
                if (scorers.get(x).getKnown_as().equalsIgnoreCase(usersPlayerName)) {
                    if (x == i) {
                        result += 10;
                    } else {
                        result += 5;
                    }
                }
            }
        }
    }

    public void calculateTopAssist() {
        for (int i = 0; i < 3; i++) {
            String usersPlayerName = userAssists.get(i).getNameOfPlayer();
            for (int x = 0; x < 3; x++) {
                if (assists.get(x).getKnown_as().equalsIgnoreCase(usersPlayerName)) {
                    if (x == i) {
                        result += 10;
                    } else {
                        result += 5;
                    }
                }
            }
        }
    }

    public void calculateTopCleanSheet() {
        for (int i = 0; i < 3; i++) {
            String usersPlayerName = userCleanSheets.get(i).getNameOfPlayer();
            for (int x = 0; x < 3; x++) {
                if (cleanSheets.get(x).getKnown_as().equalsIgnoreCase(usersPlayerName)) {
                    if (x == i) {
                        result += 10;
                    } else {
                        result += 5;
                    }
                }
            }
        }
    }

    public int getResult() {
        return result;
    }

}
