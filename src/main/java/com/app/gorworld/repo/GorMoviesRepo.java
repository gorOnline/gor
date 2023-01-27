package com.app.gorworld.repo;

import com.app.gorworld.model.GorMovies;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface GorMoviesRepo extends MongoRepository<GorMovies, UUID> {
}
