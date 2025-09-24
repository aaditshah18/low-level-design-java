package com.notificationsystem.model;

import com.notificationsystem.enums.VitalType;
import com.notificationsystem.util.IdGenerator;

import java.util.HashMap;
import java.util.Map;

public class Patient {
    private final String id;
    private String name;
    private Map<VitalType, Double> vitals; // {"Heartrate":120}
    public Patient(String name) {
        this.name = name;
        this.id = IdGenerator.generateId();
        this.vitals = new HashMap<>();
    }

    public String getName() {return this.name;}
    public String getId() {return this.id;}

    public Double getVital(VitalType vitalName) {
        return this.vitals.get(vitalName);
    }

    public Map<VitalType, Double> getAllVitals() {
        return this.vitals;
    }

    public void setName(String name) {this.name=name;}

    public void setVital(VitalType vitalName, Double value) {
        this.vitals.put(vitalName, value);
    }

}