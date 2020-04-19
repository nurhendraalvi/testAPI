package com.example.clubadapter;

import java.util.List;

public class Club1Response {
    private List<TeamsItem> teams;

    public List<TeamsItem> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamsItem> teams) {
        this.teams = teams;
    }

    @Override
    public String toString() {
        return
                "ClubResponse{" +
                        "teams = '" + teams + '\'' +
                        "}";
    }
}