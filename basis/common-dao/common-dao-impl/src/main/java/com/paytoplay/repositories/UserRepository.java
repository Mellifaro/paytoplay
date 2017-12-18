package com.paytoplay.repositories;

import com.paytoplay.entities.user.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository bean for working with user entity
 * @author v.skapoushchenko
 */
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long>{
}
