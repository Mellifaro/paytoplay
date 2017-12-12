package com.paytoplay.entities.user;

import com.paytoplay.entities.NamedEntity;
import com.paytoplay.utils.CommonUtil;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Entity, that contains all user's information
 * @author v.skapoushchenko
 */
@Entity
@Table(name = "users")
public class User extends NamedEntity {

    @NotEmpty
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty
    @Column(name = "phone")
    private String phone;

    @NotEmpty
    @Email
    @Column(name = "email")
    private String email;

    @NotEmpty
    @Length(min = 5)
    @Column(name = "password")
    //TODO create hash for passwords
    private String password;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "updated_time")
    private LocalDateTime updatedTime;

    @Column(name = "enabled_buy")
    private boolean isEnabledToBuy;

    @Column(name = "enabled_sell")
    private boolean isEnabledToSell;

    /**
     * Set of roles linked to this user
     */
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.LAZY)
    private Set<UserRole> roles;

    //TODO Default constructor
    public User(){}

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
