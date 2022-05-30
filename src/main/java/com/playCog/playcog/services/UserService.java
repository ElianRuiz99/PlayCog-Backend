package com.playCog.playcog.services;

import com.playCog.playcog.models.User;
import com.playCog.playcog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //Guardar
    public User saveUser(User user){
        return userRepository.save(user);
    }

    //Eliminar por Id
    public void daleteUser(int id){
        userRepository.deleteById(id);
    }

    //Listar por id
    //public User getUserById(int id){
    //    return userRepository.findUserById(id);
    //}

    //Listar por correo
    public User getUserByEmail(String email){
        return  userRepository.findUserByCorreo(email);
    }

}
