package com.notificationsystem.model;

import com.notificationsystem.enums.VitalType;
import com.notificationsystem.util.IdGenerator;

import java.util.HashMap;
import java.util.Map;

public class Patient {
    private final String id;
    private String name;

    public Patient() {
        this.id = IdGenerator.generateId();
    }

    public String getName() {return this.name;}
    public String getId() {return this.id;}


    public void setName(String name) {this.name=name;}


}