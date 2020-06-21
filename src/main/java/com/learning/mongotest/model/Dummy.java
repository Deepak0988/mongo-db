package com.learning.mongotest.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "dummy")
@ApiModel(description = "Dummy Model")
public class Dummy {

    @Id
    @Getter
    @Setter
    @ApiModelProperty(notes = "The database generated employee ID")
    private Long id;

    @Field(value="first_name")
    @Getter
    @Setter
    @ApiModelProperty(notes = "The employee first name")
    private String firstName;
}
