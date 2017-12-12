package com.paytoplay.repository;

import com.paytoplay.config.CommonDaoAppCfg;
import com.paytoplay.entities.user.User;
import com.paytoplay.entities.user.UserRole;
import com.paytoplay.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.EnumSet;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CommonDaoAppCfg.class})
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void startupTest(){
        User user = new User("mellifaro", "Ivan", "Zubko", "+380634465555", "zubko@gmail.com", "12345", EnumSet.of(UserRole.ADMIN));
        user.setId(56526525L);
        user.setFirstName("Ivan");
        user.setLastName("Zubko");
        user.setEmail("");
        user.setPhone("+380634456655");
        user.setPassword("default");
        userRepository.save(user);
    }
}
