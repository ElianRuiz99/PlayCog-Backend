package com.playCog.playcog.controller;

import com.playCog.playcog.models.User;
import com.playCog.playcog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //MICROSERVICIOS

    //crear
    @PostMapping("/create")
    public User createUser(@Validated @RequestBody User user){
        return userService.saveUser(user);
    }

    //eliminar
    @GetMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id){
        userService.daleteUser(id);
    }

    //listar
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    //actualizar
    @PutMapping("/update/{id}")
    public User updateUser (@PathVariable int id, @Validated @RequestBody User user){
        User findUser = userService.getUserById(id);
        findUser.setNombre(user.getNombre());
        findUser.setApellido(user.getApellido());
        findUser.setContrasena(user.getContrasena());
        findUser.setFecha_nacimiento(user.getFecha_nacimiento());
        findUser.setCelular(user.getCelular());
        findUser.setDireccion_residencia(user.getDireccion_residencia());
        return userService.saveUser(findUser);
    }
}
