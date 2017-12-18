package com.paytoplay.entities;

import com.paytoplay.entities.user.UserEntity;
import com.paytoplay.entities.user.UserRoleEntity;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.EnumSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Contains unit-tests to check functionality of {@link UserEntity} class
 * @author v.skapoushchenko
 */
public class UserEntityTest {
    private UserEntity userEntity;
    private static Validator validator;

    @BeforeClass
    public static void init(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Before
    public void setup(){
        userEntity = new UserEntity("mellifaro", "Ivan", "Zubko", "+380634465555", "zubko@gmail.com", "12345", EnumSet.of(UserRoleEntity.ADMIN));
    }

    @Test
    public void testCreateValidUser(){
        userEntity = new UserEntity("mellifaro", "Ivan", "Zubko", "+380634465555", "zubko@gmail.com", "12345", EnumSet.of(UserRoleEntity.ADMIN));
        Set<ConstraintViolation<UserEntity>> constraintViolations = validator.validate(userEntity);
        assertTrue(constraintViolations.isEmpty());
    }

    @Test
    public void testAddValidRolesSuccess(){
        userEntity.setRoles(EnumSet.of(UserRoleEntity.ADMIN));
        assertTrue(containsRole(userEntity, UserRoleEntity.ADMIN));
    }

    private boolean containsRole(UserEntity userEntity, UserRoleEntity role){
        return userEntity.getRoles().contains(role);
    }

    @Test(expected = NullPointerException.class)
    public void testAddNullSetRolesFailure(){
        userEntity.setRoles(null);
        assertTrue(false);
    }

    @Test
    public void testAddNullFirstNameFailure(){
        userEntity.setFirstName(null);
        Set<ConstraintViolation<UserEntity>> constraintViolations = validator.validate(userEntity);

        //Returns true if one of the violation constraints has such message
        assertTrue(constraintViolations.stream()
                        .anyMatch(violation -> violation.getMessage().equals("Incorrect first name")));
    }

    @Test
    public void testAddEmptyFirstNameFailure(){
        userEntity.setFirstName("   ");
        Set<ConstraintViolation<UserEntity>> constraintViolations = validator.validate(userEntity);

        //Returns true if one of the violation constraints has such message
        assertTrue(constraintViolations.stream()
                .anyMatch(violation -> violation.getMessage().equals("Incorrect first name")));
    }

    @Test
    public void testAddNullLastNameFailure(){
        userEntity.setLastName(null);
        Set<ConstraintViolation<UserEntity>> constraintViolations = validator.validate(userEntity);

        //Returns true if one of the violation constraints has such message
        assertTrue(constraintViolations.stream()
                .anyMatch(violation -> violation.getMessage().equals("Incorrect last name")));
    }

    @Test
    public void testAddEmptyLastNameFailure(){
        userEntity.setLastName("   ");
        Set<ConstraintViolation<UserEntity>> constraintViolations = validator.validate(userEntity);

        //Returns true if one of the violation constraints has such message
        assertTrue(constraintViolations.stream()
                .anyMatch(violation -> violation.getMessage().equals("Incorrect last name")));
    }

    @Test
    public void testAddNullPhoneFailure(){
        userEntity.setPhone(null);
        Set<ConstraintViolation<UserEntity>> constraintViolations = validator.validate(userEntity);

        //Returns true if one of the violation constraints has such message
        assertTrue(constraintViolations.stream()
                .anyMatch(violation -> violation.getMessage().equals("Phone can't be blank")));
    }

    @Test
    public void testAddEmptyPhoneFailure(){
        userEntity.setPhone("   ");
        Set<ConstraintViolation<UserEntity>> constraintViolations = validator.validate(userEntity);

        //Returns true if one of the violation constraints has such message
        assertTrue(constraintViolations.stream()
                .anyMatch(violation -> violation.getMessage().equals("Phone can't be blank")));
    }

    @Test
    public void testAddNullEmailFailure(){
        userEntity.setEmail(null);
        Set<ConstraintViolation<UserEntity>> constraintViolations = validator.validate(userEntity);

        //Returns true if one of the violation constraints has such message
        assertTrue(constraintViolations.stream()
                .anyMatch(violation -> violation.getMessage().equals("Email can't be blank")));
    }

    @Test
    public void testAddEmptyEmailFailure(){
        userEntity.setEmail("   ");
        Set<ConstraintViolation<UserEntity>> constraintViolations = validator.validate(userEntity);

        //Returns true if one of the violation constraints has such message
        assertTrue(constraintViolations.stream()
                .anyMatch(violation -> violation.getMessage().equals("Email can't be blank")));
    }

    @Test
    public void testAddNotValidEmailFailure(){
        userEntity.setEmail("wrongemail");
        Set<ConstraintViolation<UserEntity>> constraintViolations = validator.validate(userEntity);

        //Returns true if one of the violation constraints has such message
        assertTrue(constraintViolations.stream()
                .anyMatch(violation -> violation.getMessage().equals("Email is not valid")));
    }

    @Test
    public void testAddNullPasswordFailure(){
        userEntity.setPassword(null);
        Set<ConstraintViolation<UserEntity>> constraintViolations = validator.validate(userEntity);

        //Returns true if one of the violation constraints has such message
        assertTrue(constraintViolations.stream()
                .anyMatch(violation -> violation.getMessage().equals("Password can't be blank")));
    }

    @Test
    public void testAddEmptyPasswordFailure(){
        userEntity.setPassword("   ");
        Set<ConstraintViolation<UserEntity>> constraintViolations = validator.validate(userEntity);

        //Returns true if one of the violation constraints has such message
        assertTrue(constraintViolations.stream()
                .anyMatch(violation -> violation.getMessage().equals("Password can't be blank")));
    }

}
