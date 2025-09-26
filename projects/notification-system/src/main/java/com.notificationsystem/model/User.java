package com.notificationsystem.model;

import com.notificationsystem.util.IdGenerator;
import com.notificationsystem.enums.Role;

public abstract class User {
    protected final String id;
    protected String username;
    public User(String username) {
        this.username = username;
        this.id = IdGenerator.generateId();
    }

    public String getId() {return this.id;}
    public String getUsername() {return this.username;}

    public abstract Role getRole();

}