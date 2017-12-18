package com.paytoplay.repository;

import com.paytoplay.config.CommonDaoAppCfg;
import com.paytoplay.entities.user.UserEntity;
import com.paytoplay.entities.user.UserRoleEntity;
import com.paytoplay.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.EnumSet;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CommonDaoAppCfg.class})
public class UserEntityRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void startupTest(){
        UserEntity userEntity = new UserEntity("mellifaro", "Ivan", "Zubko", "+380634465555", "zubko@gmail.com", "12345", EnumSet.of(UserRoleEntity.ADMIN));
//        userEntity.setId(56526525L);
        userEntity.setFirstName("Ivan");
        userEntity.setLastName("Zubko");
        userEntity.setEmail("zubko@gmail.com");
        userEntity.setPhone("+380634456655");
        userEntity.setPassword("default");
        userRepository.save(userEntity);
    }
}
