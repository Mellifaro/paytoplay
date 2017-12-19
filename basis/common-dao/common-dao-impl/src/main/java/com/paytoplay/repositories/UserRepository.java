package com.paytoplay.repositories;

import com.paytoplay.entities.user.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository bean for working with user entity
 * @author v.skapoushchenko
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long>{
}
