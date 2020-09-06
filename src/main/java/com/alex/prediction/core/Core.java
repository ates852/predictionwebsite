package com.alex.prediction.core;

import com.alex.prediction.models.*;

import java.util.List;

public class Core {
    User user;

    protected int result = 0;

    public Core(User user) {
        this.user = user;
    }

    public int calculateStandings(List<UserTeam> userTeams, List<Team> teams) {
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
        return result;
    }

    public int calculateTopScorer(List<UserScorer> userScorers, List<Scorer> scorers) {
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
        return result;
    }

    public int calculateTopAssist(List<UserAssist> userAssists, List<Assist> assists) {
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
        return result;
    }

    public int calculateTopCleanSheet(List<UserCleanSheet> userCleanSheets, List<CleanSheet> cleanSheets) {
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
        return result;
    }
}
