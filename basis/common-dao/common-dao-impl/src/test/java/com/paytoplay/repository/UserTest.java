package com.paytoplay.repository;

import com.paytoplay.entities.User;
import com.paytoplay.entities.UserRole;
import org.junit.Test;

import java.util.EnumSet;

import static org.junit.Assert.*;

/**
 * Contains unit-tests to check functionality of {@link com.paytoplay.entities.User} class
 * @author v.skapoushchenko
 */
public class UserTest {

    @Test
    public void testAddValidRolesSuccess(){
        User user = new User();
        user.setRoles(EnumSet.of(UserRole.ADMIN));

        assertTrue(containsRole(user, UserRole.ADMIN));
    }

    private boolean containsRole(User user, UserRole role){
        return user.getRoles().contains(role);
    }
}
