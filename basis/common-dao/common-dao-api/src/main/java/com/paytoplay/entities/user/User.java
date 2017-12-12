package com.paytoplay.entities.user;


import com.paytoplay.entities.NamedEntity;
import com.paytoplay.utils.CommonUtil;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Entity, that contains all user's information
 * @author v.skapoushchenko
 */
@Entity
@Table(name = "users")
public class User extends NamedEntity {

    @NotBlank(message = "Incorrect first name")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Incorrect last name")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "Phone can't be blank")
    @Size(min = 2, max = 15, message = "Phone length can't be less than 2 or more than 15 characters")
    @Column(name = "phone")
    private String phone;

    @NotBlank(message = "Email can't be blank")
    @Email(message = "Email is not valid")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "Password can't be blank")
    @Column(name = "password")
    //TODO create hash for passwords
    private String password;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "updated_time")
    private LocalDateTime updatedTime;

    @Column(name = "enabled_buy")
    private boolean enabledToBuy;

    @Column(name = "enabled_sell")
    private boolean enabledToSell;

    /**
     * Set of roles linked to this user
     */
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.LAZY)
    private Set<UserRole> roles;

    //TODO Default constructor

    public User(String login, String firstName, String lastName, String phone, String email, String password, Set<UserRole> roles){
        super(null, login);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.createdTime = LocalDateTime.now();
        this.updatedTime = LocalDateTime.now();
        this.enabledToBuy = true;
        this.enabledToSell = true;
    }

    public Set<UserRole> getRoles() {
        return CommonUtil.getSafeSet(roles);
    }

    public void setRoles(Set<UserRole> roles) {
        Objects.requireNonNull(roles, "Set of roles can't be null");
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

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    public boolean isEnabledToBuy() {
        return enabledToBuy;
    }

    public void setEnabledToBuy(boolean enabledToBuy) {
        this.enabledToBuy = enabledToBuy;
    }

    public boolean isEnabledToSell() {
        return enabledToSell;
    }

    public void setEnabledToSell(boolean enabledToSell) {
        this.enabledToSell = enabledToSell;
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
                ", enabledToBuy=" + enabledToBuy +
                ", enabledToSell=" + enabledToSell +
                ", roles=" + roles +
                '}';
    }
}
