package com.paytoplay.entities.user;

import com.paytoplay.entities.NamedEntity;
import com.paytoplay.utils.CommonUtil;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Entity, that contains all user's information
 */
@Entity
public class User extends NamedEntity {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String phone;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Length(min = 5)
    private String password;

    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private boolean isEnabledToBuy;
    private boolean isEnabledToSell;

    /**
     * Set of roles linked to this user
     */
    private Set<UserRole> roles;

    //TODO Default constructor

    public User(String name, Set<UserRole> roles){
        super(null, name);
        this.roles = roles;
    }

    public Set<UserRole> getRoles() {
        return CommonUtil.getSafeSet(roles);
    }

    public void setRoles(Set<UserRole> roles) {
        Objects.requireNonNull(roles, "Roles parameter is not initialized");
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", createdDate=" + createdTime +
                ", updatedTime=" + updatedTime +
                ", isEnabledToBuy=" + isEnabledToBuy +
                ", isEnabledToSell=" + isEnabledToSell +
                ", roles=" + roles +
                '}';
    }
}
