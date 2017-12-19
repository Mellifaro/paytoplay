package com.paytoplay.repository;

import com.paytoplay.config.CommonDaoAppCfg;
import com.paytoplay.entities.game.Game;
import com.paytoplay.entities.game.Server;
import com.paytoplay.entities.game.ServerType;
import com.paytoplay.repositories.GameEntityRepository;
import com.paytoplay.repositories.ServerEntityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CommonDaoAppCfg.class})
public class GameRepositoryTets {

    @Autowired
    private GameEntityRepository gameEntityRepository;

    @Autowired
    private ServerEntityRepository serverEntityRepository;

    @Test
    //TODO Implement method save in serverService properly
    public void startupTest(){
        Game game = new Game();
        game.setName("Perfect World");
        game.setDescription("MMORPG");

        ServerType serverType = new ServerType();
        serverType.setServerType("Free");

        Server server = new Server("Orion", new HashSet<ServerType>(){{add(serverType);}}, game);
        serverEntityRepository.save(server);
    }
}
