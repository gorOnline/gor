package com.app.gorworld.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "gorMovies")
@AllArgsConstructor
@Getter
@Setter
public class GorMovies {
    @Id
    UUID id;
    String name;
    String imgUrl;
    String videoUrl;
}
