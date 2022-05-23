package com.playCog.playcog.controller;

import com.playCog.playcog.models.Videogame;
import com.playCog.playcog.services.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/videogame")
public class VideogameController {
    @Autowired
    private VideogameService videogameService;

    //listarTodo
    @GetMapping("/list")
    public List<Videogame> getAllC(){
        return videogameService.getAllS();
    }
}
