package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.edutech.progressive.entity.Cricketer;
import com.edutech.progressive.service.CricketerService;

public class CricketerServiceImplArraylist implements CricketerService {
    private List<Cricketer> cricketers = new ArrayList<>();

    public CricketerServiceImplArraylist() {
        cricketers.add(new Cricketer(1, 101, "A. Sharma", 30, "India", 8, "Batsman", 4200, 5));
        cricketers.add(new Cricketer(2, 102, "B. Singh", 28, "India", 5, "Bowler", 300, 85));
        cricketers.add(new Cricketer(3, 101, "C. Khan", 26, "Pakistan", 3, "All-rounder", 1200, 35));
        cricketers.add(new Cricketer(4, 103, "D. Patel", 31, "India", 10, "Wicketkeeper", 2500, 2));
    }

    @Override
    public List<Cricketer> getAllCricketers() {
        return cricketers;
    }
    @Override
    public Integer addCricketer(Cricketer cricketer) {
        cricketers.add(cricketer);
        return cricketers.size();
    }
    @Override
    public List<Cricketer> getAllCricketersSortedByExperience() {
        Collections.sort(cricketers);
        return cricketers;
    }
    @Override
    public void emptyArrayList() {
        CricketerService.super.emptyArrayList();
        cricketers = new ArrayList<>();
    }
}