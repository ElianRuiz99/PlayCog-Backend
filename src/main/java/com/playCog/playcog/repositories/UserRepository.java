package com.playCog.playcog.repositories;

import com.playCog.playcog.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    //public User findUserById(int id);

    public User findUserByCorreo(String email);

}
