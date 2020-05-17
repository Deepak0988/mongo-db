package com.learning.mongotest.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "app_user")
public class AppUser {
    @Id
    @Getter
    @Setter
    private Long id;

    @Field(value="first_name")
    @Getter
    @Setter
    private String firstName;

    @Field(value="last_name")
    @Getter
    @Setter
    private String lastName;
}
