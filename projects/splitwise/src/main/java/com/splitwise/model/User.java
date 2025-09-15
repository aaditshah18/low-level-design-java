package com.splitwise.model;

import com.splitwise.util.IdGenerator;

public class User {
    private final String Id;
    private final String email;
    private final String mobile;
    private String name;

    public User(String email, String mobile, String name) {
        this.Id = IdGenerator.generateId();
        this.email = email;
        this.mobile = mobile;
        this.name = name;
    }

    public String getId() { return Id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getMobile() { return mobile; }

    public void setName() {this.name=name;}

}