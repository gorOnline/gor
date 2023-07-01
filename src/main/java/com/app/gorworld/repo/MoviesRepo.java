package com.app.gorworld.repo;

import com.app.gorworld.model.Movies;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface MoviesRepo extends MongoRepository<Movies, Long> {
}
