package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Team;
import com.edutech.progressive.exception.TeamAlreadyExistsException;
import com.edutech.progressive.exception.TeamDoesNotExistException;
import com.edutech.progressive.repository.CricketerRepository;
import com.edutech.progressive.repository.MatchRepository;
import com.edutech.progressive.repository.TeamRepository;
import com.edutech.progressive.repository.TicketBookingRepository;
import com.edutech.progressive.repository.VoteRepository;
import com.edutech.progressive.service.TeamService;

@Service
public class TeamServiceImplJpa implements TeamService {
    private TeamRepository teamRepository;

    @Autowired
    TicketBookingRepository ticketBookingRepository;
 
    @Autowired
    CricketerRepository cricketerRepository;
 
    @Autowired
    MatchRepository matchRepository;
 
    @Autowired
    VoteRepository voteRepository;
    
    @Autowired
    public TeamServiceImplJpa(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public List<Team> getAllTeams() throws SQLException {
        return teamRepository.findAll();
    }

    @Override
    public int addTeam(Team team) throws SQLException {
        if (teamRepository.findByTeamId(team.getTeamId()) != null) {
            throw new TeamAlreadyExistsException("Team already exists");
        }
        return teamRepository.save(team).getTeamId();
        
    }

    @Override
    public List<Team> getAllTeamsSortedByName() throws SQLException {
        List<Team> sortedTeam = teamRepository.findAll();
        sortedTeam.sort(Comparator.comparing(Team::getTeamName));
        return sortedTeam;
    }

    public Team getTeamById(int teamId) throws SQLException {
        Team team = teamRepository.findByTeamId(teamId);
        if (team == null) {
            throw new TeamDoesNotExistException("Team doesn't exist");
        }
        return team;
    }
 
    @Override
    public void updateTeam(Team team) throws SQLException {
        Team sameNameTeam = teamRepository.findByTeamName(team.getTeamName());
        if (sameNameTeam != null && sameNameTeam.getTeamId() != team.getTeamId()) {
            throw new TeamAlreadyExistsException("Team with the same name already exists, TeamName = " + team.getTeamName());
        }
        Team teamDetails = getTeamById(team.getTeamId());
        teamDetails.setTeamName(team.getTeamName());
        teamDetails.setOwnerName(team.getOwnerName());
        teamDetails.setLocation(team.getLocation());
        teamDetails.setEstablishmentYear(team.getEstablishmentYear());
        teamRepository.save(teamDetails);
    }
 
    @Override
    public void deleteTeam(int teamId) throws SQLException {
        voteRepository.deleteByTeamId(teamId);
        ticketBookingRepository.deleteByTeamId(teamId);
        matchRepository.deleteByTeamId(teamId);
        cricketerRepository.deleteByTeamId(teamId);
        teamRepository.deleteById(teamId);
    }
    
}