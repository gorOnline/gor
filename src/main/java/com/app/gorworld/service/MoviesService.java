package com.app.gorworld.service;

import com.app.gorworld.model.Movies;
import com.app.gorworld.repo.MoviesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MoviesService {
    @Autowired
    MoviesRepo moviesRepo;

    @Autowired
    MongoSequenceGeneratorService sequenceGeneratorService;

    public List<Movies> listMovies() {
        //createDummyListMovies();
        return moviesRepo.findAll();
    }

    private void createDummyListMovies() {
        Movies m1 = new Movies(sequenceGeneratorService.getSequenceNumber(Movies.SEQUENCE_NAME), "Venom", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTxqrFd7qmvG0OjGi1_22jLp3B4V3vtayhQVw&usqp=CAU", "https://youtu.be/8ugaeA-nMTc");
        Movies m2 = new Movies(sequenceGeneratorService.getSequenceNumber(Movies.SEQUENCE_NAME), "Pathan", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGLzaY4Fdq4lJXrl_8py0dJtFF_2ujR4Jeyg&usqp=CAU", "https://youtu.be/8ugaeA-nMTc");
        Movies m3 = new Movies(sequenceGeneratorService.getSequenceNumber(Movies.SEQUENCE_NAME), "Major", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQNnajYlDzPlaXsUw2oIZpao__9e8svoBDpAQ&usqp=CAU", "https://youtu.be/8ugaeA-nMTc");
        Movies m4 = new Movies(sequenceGeneratorService.getSequenceNumber(Movies.SEQUENCE_NAME), "Blade-Runnner", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSSgsa8pPMJ-txgU-8nEpYT5PU2ffyemM6pseW9Pjuvwo-CZaBKmM7_ZUwRnMjS5hFqgyo&usqp=CAU", "https://youtu.be/8ugaeA-nMTc");
        moviesRepo.deleteAll();
        saveMovies(Arrays.asList(m1, m2, m3, m4));
    }

    public List<Movies> saveMovies(List<Movies> movies) {
        return moviesRepo.saveAll(movies);
    }

    public Movies createMovie(Movies movie) {
        Movies res = new Movies();
        res.setId(sequenceGeneratorService.getSequenceNumber(Movies.SEQUENCE_NAME));
        res.setName(movie.getName());
        res.setImgUrl(movie.getImgUrl());
        res.setVideoUrl(movie.getVideoUrl());
        return moviesRepo.save(res);
    }

    public List<Long> createMovies(List<Movies> movies) {
        List<Long> list = new ArrayList<>();
        for (Movies movie : movies) {
            Movies res = new Movies();
            res.setId(sequenceGeneratorService.getSequenceNumber(Movies.SEQUENCE_NAME));
            res.setName(movie.getName());
            res.setImgUrl(movie.getImgUrl());
            res.setVideoUrl(movie.getVideoUrl());
            Movies save = moviesRepo.save(res);
            list.add(save.getId());
        }
        return list;
    }
}
