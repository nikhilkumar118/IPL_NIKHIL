package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.entity.Cricketer;
import com.edutech.progressive.service.CricketerService;

public class CricketerServiceImplArraylist implements CricketerService {
    private final List<Cricketer> cricketers = new ArrayList<>();
    @Override
    public List<Cricketer> getAllCricketers() {
        // Placeholder stub
        return new ArrayList<>();
    }
    @Override
    public Integer addCricketer(Cricketer cricketer) {
        // Placeholder stub
        return -1;
    }
    @Override
    public List<Cricketer> getAllCricketersSortedByExperience() {
        // Placeholder stub
        return new ArrayList<>();
    }
    @Override
    public void emptyArrayList() {
        // Call default no-op for Day 1
        // CricketerService.super.emptyArrayList();
    }
}