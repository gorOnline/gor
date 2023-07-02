package com.app.gorworld.repo;

import com.app.gorworld.model.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MoviesRepo extends JpaRepository<Movies, Long> {
}
