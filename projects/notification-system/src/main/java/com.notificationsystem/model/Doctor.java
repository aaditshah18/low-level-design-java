package com.notificationsystem.model;

import com.notificationsystem.enums.Role;

public class Doctor extends User {
    public Doctor(String username) {
        super(username);
    }

    @Override
    public Role getRole() {return Role.ROLE_DOCTOR;}
}