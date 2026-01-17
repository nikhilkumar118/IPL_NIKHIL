package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.dao.TeamDAO;
import com.edutech.progressive.entity.Team;
import com.edutech.progressive.service.TeamService;

public class TeamServiceImplJdbc implements TeamService {
    private final TeamDAO teamDAO;
    public TeamServiceImplJdbc(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }
    @Override
    public List<Team> getAllTeams() {
        
        return new ArrayList<>();
    }
    @Override
    public int addTeam(Team team) {
        
        return -1;
    }
    @Override
    public List<Team> getAllTeamsSortedByName() {
        
        return new ArrayList<>();
    }
    public Team getTeamById(int teamId) {
        
        return null;
    }
    public void updateTeam(Team team) {
        
    }
    public void deleteTeam(int teamId) {
        
    }
}