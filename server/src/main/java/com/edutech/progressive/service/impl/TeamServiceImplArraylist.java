package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.edutech.progressive.entity.Team;
import com.edutech.progressive.service.TeamService;

public class TeamServiceImplArraylist implements TeamService {

    List<Team> list = new ArrayList<>();

    @Override
    public List<Team> getAllTeams() {
        return list;
    }

    @Override
    public int addTeam(Team team) {
        list.add(team);
        return 1;
    }

    @Override
    public List<Team> getAllTeamsSortedByName() {
        List<Team> sorted = new ArrayList<>(list);
        Collections.sort(sorted, new Comparator<Team>() {

            @Override
            public int compare(Team arg0, Team arg1) {
                return arg0.getTeamName().compareToIgnoreCase(arg1.getTeamName());
            }
            
        });
        return sorted;
    }

}