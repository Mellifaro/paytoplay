package com.paytoplay.repository;

import com.paytoplay.entities.user.User;
import com.paytoplay.entities.user.UserRole;
import org.junit.Before;
import org.junit.Test;

import java.util.EnumSet;

import static org.junit.Assert.*;

/**
 * Contains unit-tests to check functionality of {@link User} class
 * @author v.skapoushchenko
 */
public class UserTest {
    private User user;

    @Before
    public void setup(){
        user = new User("mellifaro", EnumSet.of(UserRole.ADMIN));
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

}
