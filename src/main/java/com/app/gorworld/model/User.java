package com.app.gorworld.model;

import com.app.gorworld.model.enums.PLAN;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";

    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    Long id;
    String name;

    @Indexed(unique = true)
    String mobileNumber;

    PLAN plan;
    Boolean active = true;
    Date planDate;
}
