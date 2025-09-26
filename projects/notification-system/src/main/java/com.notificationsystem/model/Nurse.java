package com.notificationsystem.model;

import com.notificationsystem.enums.Role;

public class Nurse extends User {
    public Nurse(String username) {
        super(username);
    }

    @Override
    public Role getRole() {return Role.ROLE_NURSE;}
}