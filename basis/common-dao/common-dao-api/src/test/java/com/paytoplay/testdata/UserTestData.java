package com.paytoplay.testdata;

import com.paytoplay.entities.user.UserEntity;
import com.paytoplay.entities.user.UserRoleEntity;
import com.paytoplay.entities.user.UserUpdateDataEntity;

import java.time.LocalDateTime;
import java.util.EnumSet;

public class UserTestData {
    public static final long ADMIN_ID = UserEntity.USER_SEQ;
    public static final long SELLER_ID = UserEntity.USER_SEQ + 1;
    public static final long BUYER_ID = UserEntity.USER_SEQ + 2;

    public static final long ADMIN_DATA_UPDATED_ID_1 = UserUpdateDataEntity.USER_UPDATE_INFO_SEQ;
    public static final long ADMIN_DATA_UPDATED_ID_2 = UserUpdateDataEntity.USER_UPDATE_INFO_SEQ + 1;
    public static final long SELLER_DATA_UPDATED_ID_1 = UserUpdateDataEntity.USER_UPDATE_INFO_SEQ + 2;

    public static final UserEntity ADMIN = new UserEntity(ADMIN_ID, "admin", "Jon", "Snow", "+380634401122", "admin@gmail.com", "admin_password", EnumSet.of(UserRoleEntity.ADMIN));
    public static final UserEntity SELLER = new UserEntity(SELLER_ID, "seller", "Tiriron", "Lanister", "+380674403344", "seller@gmail.com", "seller_password", EnumSet.of(UserRoleEntity.SELLER));
    public static final UserEntity BUYER = new UserEntity(BUYER_ID, "buyer", "Ned", "Stark", "+380632536571", "buyer@gmail.com", "buyer_password", EnumSet.of(UserRoleEntity.BUYER));

    public static final UserUpdateDataEntity ADMIN_DATA_UPDATED_1 = new UserUpdateDataEntity(ADMIN_DATA_UPDATED_ID_1, "+777777777", null, "admin123_password", LocalDateTime.now(), ADMIN);
    public static final UserUpdateDataEntity ADMIN_DATA_UPDATED_2 = new UserUpdateDataEntity(ADMIN_DATA_UPDATED_ID_2, "+888888888", "admin1238@gmail.com", "admin1238_password", LocalDateTime.now(), ADMIN);
    public static final UserUpdateDataEntity SELLER_DATA_UPDATED_1 = new UserUpdateDataEntity(SELLER_DATA_UPDATED_ID_1, "+3806744033442", null, "seller_password2", LocalDateTime.now(), SELLER);


}
