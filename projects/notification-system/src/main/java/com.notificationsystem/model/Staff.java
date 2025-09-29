package com.notificationsystem.model;

import com.notificationsystem.enums.Role;

public class Staff extends User {
    public Staff(String username) {
        super(username);
    }

    @Override
    public Role getRole() {return Role.ROLE_STAFF;}
}