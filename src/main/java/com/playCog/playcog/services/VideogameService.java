package com.playCog.playcog.services;

import com.playCog.playcog.models.Videogame;
import com.playCog.playcog.repositories.VideogameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideogameService {
    @Autowired
    private VideogameRepository videogameRepository;

    //listarTodo
    public List<Videogame> getAllS(){
        return videogameRepository.findAll();
    }
}
