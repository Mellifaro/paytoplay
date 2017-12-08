package com.paytoplay.entities;

import java.util.Set;

public class User extends NamedEntity{

    private Set<UserRole> roles;

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }
}
