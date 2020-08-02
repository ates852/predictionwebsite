package com.alex.prediction.repository;

import com.alex.prediction.domain.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {
    User findByStandingsId(int standingsId);

    User findByName(String name);
}
