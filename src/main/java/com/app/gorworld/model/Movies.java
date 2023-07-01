package com.app.gorworld.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "gor_movies")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Movies {
    @Transient
    public static final String SEQUENCE_NAME = "movie_sequence";

    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    Long id;
    String name;
    String imgUrl;
    String videoUrl;
}
