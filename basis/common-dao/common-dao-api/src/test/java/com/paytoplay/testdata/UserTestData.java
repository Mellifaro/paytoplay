package com.paytoplay.testdata;

import com.paytoplay.entities.user.User;
import com.paytoplay.entities.user.UserRole;
import com.paytoplay.entities.user.UserUpdateData;

import java.time.LocalDateTime;
import java.util.EnumSet;

public class UserTestData {
    public static final long ADMIN_ID = User.USER_SEQ;
    public static final long SELLER_ID = User.USER_SEQ + 1;
    public static final long BUYER_ID = User.USER_SEQ + 2;

    public static final long ADMIN_DATA_UPDATED_ID_1 = UserUpdateData.USER_UPDATE_INFO_SEQ;
    public static final long ADMIN_DATA_UPDATED_ID_2 = UserUpdateData.USER_UPDATE_INFO_SEQ + 1;
    public static final long SELLER_DATA_UPDATED_ID_1 = UserUpdateData.USER_UPDATE_INFO_SEQ + 2;

    public static final User ADMIN = new User(ADMIN_ID, "admin", "Jon", "Snow", "+380634401122", "admin@gmail.com", "admin_password", EnumSet.of(UserRole.ADMIN));
    public static final User SELLER = new User(SELLER_ID, "seller", "Tiriron", "Lanister", "+380674403344", "seller@gmail.com", "seller_password", EnumSet.of(UserRole.SELLER));
    public static final User BUYER = new User(BUYER_ID, "buyer", "Ned", "Stark", "+380632536571", "buyer@gmail.com", "buyer_password", EnumSet.of(UserRole.BUYER));

    public static final UserUpdateData ADMIN_DATA_UPDATED_1 = new UserUpdateData(ADMIN_DATA_UPDATED_ID_1, "+777777777", null, "admin123_password", LocalDateTime.now(), ADMIN);
    public static final UserUpdateData ADMIN_DATA_UPDATED_2 = new UserUpdateData(ADMIN_DATA_UPDATED_ID_2, "+888888888", "admin1238@gmail.com", "admin1238_password", LocalDateTime.now(), ADMIN);
    public static final UserUpdateData SELLER_DATA_UPDATED_1 = new UserUpdateData(SELLER_DATA_UPDATED_ID_1, "+3806744033442", null, "seller_password2", LocalDateTime.now(), SELLER);


}
