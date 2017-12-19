package com.paytoplay.repositories;

import com.paytoplay.entities.game.Game;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GameEntityRepository extends PagingAndSortingRepository<Game, Long> {
}
