package com.app.gorworld.service;

import com.app.gorworld.model.GorMovies;
import com.app.gorworld.repo.GorMoviesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GorMoviesService {
    @Autowired GorMoviesRepo gorMoviesRepo;

    public List<GorMovies> listMovies(){
        return gorMoviesRepo.findAll();
    }

    public List<GorMovies> saveMovies(List<GorMovies> movies) {
        return gorMoviesRepo.saveAll(movies);
    }
}
