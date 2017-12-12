package com.paytoplay.entities;

import com.paytoplay.entities.user.User;
import com.paytoplay.entities.user.UserRole;
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
 * Contains unit-tests to check functionality of {@link User} class
 * @author v.skapoushchenko
 */
public class UserTest {
    private User user;
    private static Validator validator;

    @BeforeClass
    public static void init(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Before
    public void setup(){
        user = new User("mellifaro", "Ivan", "Zubko", "+380634465555", "zubko@gmail.com", "12345", EnumSet.of(UserRole.ADMIN));
    }

    @Test
    public void testCreateValidUser(){
        user = new User("mellifaro", "Ivan", "Zubko", "+380634465555", "zubko@gmail.com", "12345", EnumSet.of(UserRole.ADMIN));
        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
        assertTrue(constraintViolations.isEmpty());
    }

    @Test
    public void testAddValidRolesSuccess(){
        user.setRoles(EnumSet.of(UserRole.ADMIN));
        assertTrue(containsRole(user, UserRole.ADMIN));
    }

    private boolean containsRole(User user, UserRole role){
        return user.getRoles().contains(role);
    }

    @Test(expected = NullPointerException.class)
    public void testAddNullSetRolesFailure(){
        user.setRoles(null);
        assertTrue(false);
    }

    @Test
    public void testAddNullFirstNameFailure(){
        user.setFirstName(null);
        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);

        //Returns true if one of the violation constraints has such message
        assertTrue(constraintViolations.stream()
                        .anyMatch(violation -> violation.getMessage().equals("Incorrect first name")));
    }

    @Test
    public void testAddEmptyFirstNameFailure(){
        user.setFirstName("   ");
        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);

        //Returns true if one of the violation constraints has such message
        assertTrue(constraintViolations.stream()
                .anyMatch(violation -> violation.getMessage().equals("Incorrect first name")));
    }

    @Test
    public void testAddNullLastNameFailure(){
        user.setLastName(null);
        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);

        //Returns true if one of the violation constraints has such message
        assertTrue(constraintViolations.stream()
                .anyMatch(violation -> violation.getMessage().equals("Incorrect last name")));
    }

    @Test
    public void testAddEmptyLastNameFailure(){
        user.setLastName("   ");
        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);

        //Returns true if one of the violation constraints has such message
        assertTrue(constraintViolations.stream()
                .anyMatch(violation -> violation.getMessage().equals("Incorrect last name")));
    }

    @Test
    public void testAddNullPhoneFailure(){
        user.setPhone(null);
        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);

        //Returns true if one of the violation constraints has such message
        assertTrue(constraintViolations.stream()
                .anyMatch(violation -> violation.getMessage().equals("Phone can't be blank")));
    }

    @Test
    public void testAddEmptyPhoneFailure(){
        user.setPhone("   ");
        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);

        //Returns true if one of the violation constraints has such message
        assertTrue(constraintViolations.stream()
                .anyMatch(violation -> violation.getMessage().equals("Phone can't be blank")));
    }

    @Test
    public void testAddNullEmailFailure(){
        user.setEmail(null);
        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);

        //Returns true if one of the violation constraints has such message
        assertTrue(constraintViolations.stream()
                .anyMatch(violation -> violation.getMessage().equals("Email can't be blank")));
    }

    @Test
    public void testAddEmptyEmailFailure(){
        user.setEmail("   ");
        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);

        //Returns true if one of the violation constraints has such message
        assertTrue(constraintViolations.stream()
                .anyMatch(violation -> violation.getMessage().equals("Email can't be blank")));
    }

    @Test
    public void testAddNotValidEmailFailure(){
        user.setEmail("wrongemail");
        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);

        //Returns true if one of the violation constraints has such message
        assertTrue(constraintViolations.stream()
                .anyMatch(violation -> violation.getMessage().equals("Email is not valid")));
    }

    @Test
    public void testAddNullPasswordFailure(){
        user.setPassword(null);
        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);

        //Returns true if one of the violation constraints has such message
        assertTrue(constraintViolations.stream()
                .anyMatch(violation -> violation.getMessage().equals("Password can't be blank")));
    }

    @Test
    public void testAddEmptyPasswordFailure(){
        user.setPassword("   ");
        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);

        //Returns true if one of the violation constraints has such message
        assertTrue(constraintViolations.stream()
                .anyMatch(violation -> violation.getMessage().equals("Password can't be blank")));
    }

}
