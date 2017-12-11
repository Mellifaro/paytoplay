package com.paytoplay.entities.user;

import com.paytoplay.entities.NamedEntity;
import com.paytoplay.utils.CommonUtil;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Entity, that contains all user's information
 */
public class User extends NamedEntity {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private LocalDateTime createdDate;
    private LocalDateTime updatedTime;
    private boolean isEnabledToBuy;
    private boolean isEnabledToSell;
    private String password;

    /**
     * Set of roles linked to this user
     */
    private Set<UserRole> roles;

    //TODO Default constructor

    public User(String name, Set<UserRole> roles){
        super(name);
        this.roles = roles;
    }

    public Set<UserRole> getRoles() {
        return CommonUtil.getSafeSet(roles);
    }

    public void setRoles(Set<UserRole> roles) {
        Objects.requireNonNull(roles, "Roles parameter is not initialized");
        this.roles = roles;
    }
}
