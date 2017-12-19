package com.paytoplay.entities.user;

import com.paytoplay.entities.BaseEntity;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;


/**
 * Entity, that contains all changed user data
 * @author v.skapoushchenko
 */
@Entity
@Table(name = "user_update_data")
public class UserUpdateData extends BaseEntity{
    public static final int USER_UPDATE_INFO_SEQ = 100;

    @Column(name = "phone")
    private String phone;

    @Email(message = "Email is not valid")
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    //TODO create hash for passwords
    private String password;

    @Column(name = "updated_time")
    private LocalDateTime updatedDate;

    @NotNull(message = "User can't be null")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public UserUpdateData(){}

    public UserUpdateData(User user) {
        updateFieldsFromUserEntity(user);
    }

    public UserUpdateData(Long id, String phone, String email, String password, LocalDateTime updatedDate, User user) {
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.updatedDate = updatedDate;
        this.user = user;
    }

    /**
     * This method updates fields with the fields of valid {@link User}
     * @param user is valid {@link User}
     * @throws NullPointerException if user is null
     */
    private void updateFieldsFromUserEntity(@Valid User user){
        Objects.requireNonNull(user, "User can't be null");
        this.phone = user.getPhone();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.updatedDate = user.getUpdatedTime();
        this.user = user;
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

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    //todo we return object, that can be changed. Think about concurrency
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserUpdateData{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", updatedDate=" + updatedDate +
                ", userEntityId=" + user.getId() +
                ", id=" + id +
                '}';
    }
}
