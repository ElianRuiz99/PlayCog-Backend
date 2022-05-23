package com.playCog.playcog.repositories;

import com.playCog.playcog.models.Videogame;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VideogameRepository extends CrudRepository<Videogame, Integer> {
    @Override
    public List<Videogame> findAll();
}
