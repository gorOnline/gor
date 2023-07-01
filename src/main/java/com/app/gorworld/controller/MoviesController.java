package com.app.gorworld.controller;

import com.app.gorworld.model.Movies;
import com.app.gorworld.service.MoviesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {
    Logger log = LoggerFactory.getLogger(MoviesController.class);
    @Autowired
    MoviesService moviesService;

    @GetMapping("/list")
    public ResponseEntity<List<Movies>> listMovies(){

        List<Movies> result = moviesService.listMovies();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody Movies movie){
        try {
            Long result = moviesService.createMovie(movie).getId();
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create/all")
    public ResponseEntity<?> createUser(@RequestBody List<Movies> movies){
        try {
            List<Long> result = moviesService.createMovies(movies);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("test")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("test Successfull", HttpStatus.OK);
    }
}
