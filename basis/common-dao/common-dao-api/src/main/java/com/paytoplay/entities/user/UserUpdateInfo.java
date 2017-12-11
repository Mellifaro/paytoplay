package com.paytoplay.entities.user;

import com.paytoplay.entities.BaseEntity;

import java.time.LocalDateTime;

public class UserUpdateInfo extends BaseEntity{
    private String phone;
    private String email;
    private String password;
    private LocalDateTime updatedDate;
    private User user;

    public UserUpdateInfo(User user) {
        this.user = user;
    }
}
