package com.paytoplay.entities;

import com.paytoplay.entities.user.UserEntity;
import com.paytoplay.entities.user.UserRoleEntity;
import com.paytoplay.entities.user.UserUpdateDataEntity;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDateTime;
import java.util.EnumSet;
import java.util.Set;

import static com.paytoplay.testdata.UserTestData.SELLER;
import static com.paytoplay.testdata.UserTestData.SELLER_DATA_UPDATED_ID_1;
import static org.junit.Assert.*;

/**
 * Contains unit-tests to check functionality of {@link UserUpdateDataEntity} class
 * @author v.skapoushchenko
 */
public class UserUpdateDataEntityTest {

    private UserEntity admin;
    private UserUpdateDataEntity adminUpdatedData;
    private UserUpdateDataEntity sellerUpdatedData;
    private static Validator validator;

    @BeforeClass
    public static void init(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Before
    public void setup(){
        admin = new UserEntity(null, "admin", "Jon", "Snow", "+380634401122", "admin@gmail.com", "admin_password", EnumSet.of(UserRoleEntity.ADMIN));
        sellerUpdatedData = new UserUpdateDataEntity(SELLER_DATA_UPDATED_ID_1, "+3806744033442", null, "seller_password2", LocalDateTime.now(), SELLER);
    }

    @Test
    public void testUpdatedWithConstructorSuccess(){
        adminUpdatedData = new UserUpdateDataEntity(admin);
        assertTrue(adminUpdatedData.getId() == null);
        assertTrue(adminUpdatedData.getUpdatedDate() != null);
        assertTrue(adminUpdatedData.getEmail().equals(admin.getEmail()));
        assertTrue(adminUpdatedData.getPhone().equals(admin.getPhone()));
        assertTrue(adminUpdatedData.getPassword().equals(admin.getPassword()));
        assertTrue(adminUpdatedData.getUserEntity().equals(admin));
    }

    @Test
    public void testAddNullUserEntityFailure(){
        sellerUpdatedData.setUserEntity(null);
        Set<ConstraintViolation<UserUpdateDataEntity>> constraintViolations = validator.validate(sellerUpdatedData);

        //Returns true if one of the violation constraints has such message
        assertTrue(constraintViolations.stream()
                .anyMatch(violation -> violation.getMessage().equals("User can't be null")));
    }
}
