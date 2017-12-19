package com.paytoplay.repositories;

import com.paytoplay.entities.game.Server;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ServerEntityRepository extends PagingAndSortingRepository<Server, Long>{
}
