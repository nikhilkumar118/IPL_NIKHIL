package com.edutech.progressive.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Cricketer;

public class CricketerDAOImpl implements CricketerDAO{
    Connection con = DatabaseConnectionManager.getConnection();

    @Override
    public int addCricketer(Cricketer cricketer) {
        String sql = "INSERT INTO cricketer (team_id, cricketer_name, age, nationality, experience, role, total_runs, total_wickets) VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cricketer.getTeamId());
            ps.setString(2, cricketer.getCricketerName());
            ps.setInt(3, cricketer.getAge());
            ps.setString(4, cricketer.getNationality());
            ps.setInt(5, cricketer.getExperience());
            ps.setString(6, cricketer.getRole());
            ps.setInt(7, cricketer.getTotalRuns());
            ps.setInt(8, cricketer.getTotalWickets());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return -1;
    }

    @Override
    public Cricketer getCricketerById(int cricketerId) {
        String sql = "SELECT * FROM cricketer WHERE cricketer_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cricketerId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Cricketer cricketer = new Cricketer();
                cricketer.setCricketerId(rs.getInt("cricketer_id"));
                cricketer.setTeamId(rs.getInt("team_id"));
                cricketer.setCricketerName(rs.getString("cricketer_name"));
                cricketer.setAge(rs.getInt("age"));
                cricketer.setNationality(rs.getString("nationality"));
                cricketer.setExperience(rs.getInt("experience"));
                cricketer.setRole(rs.getString("role"));
                cricketer.setTotalRuns(rs.getInt("total_runs"));
                cricketer.setTotalWickets(rs.getInt("total_wickets"));
                return cricketer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateCricketer(Cricketer cricketer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCricketer'");
    }

    @Override
    public void deleteCricketer(int cricketerId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCricketer'");
    }

    @Override
    public List<Cricketer> getAllCricketers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllCricketers'");
    }

}
