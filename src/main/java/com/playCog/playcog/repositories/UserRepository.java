package com.playCog.playcog.repositories;

import com.playCog.playcog.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    public User findUserById(int id);
}
