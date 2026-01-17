package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.edutech.progressive.entity.Team;
import com.edutech.progressive.service.TeamService;

public class TeamServiceImplArraylist implements TeamService {

    List<Team> teams = new ArrayList<>();

    public TeamServiceImplArraylist() {
        teams.add(new Team(101, "Chennai Warriors", "Chennai", "R. Iyer", 2008));
        teams.add(new Team(102, "Bangalore Blazers", "Bengaluru", "S. Rao", 2009));
        teams.add(new Team(103, "Mumbai Mariners", "Mumbai", "K. Mehta", 2008));
        teams.add(new Team(104, "Delhi Dominators", "Delhi", "P. Verma", 2010));
    }

    @Override
    public List<Team> getAllTeams() {
        return teams;
    }

    @Override
    public int addTeam(Team team) {
        teams.add(team);
        return teams.size();
    }

    @Override
    public List<Team> getAllTeamsSortedByName() {
        Collections.sort(teams);
        return teams;
    }

    public void emptyArrayList(){
        TeamService.super.emptyArrayList();
        teams = new ArrayList<>();
    }

}