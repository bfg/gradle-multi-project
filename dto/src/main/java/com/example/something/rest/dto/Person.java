package com.example.something.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@Value
@Builder(toBuilder = true)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@ApiModel(value = "Person", description = "Person model description; contains name, age and interests.")
public class Person {
    /**
     * Person's name
     */
    @ApiModelProperty(required = true, example = "Joe Average", value = "Person's given name.")
    String name;

    /**
     * Person's age.
     */
    @ApiModelProperty(required = true, example = "42", value = "Person's age.")
    int age;

    /**
     * Person's interests
     */
    @ApiModelProperty(required = false, example = "['sex', 'drugs', 'rnr']", value = "Person's interests")
    @Singular("interest")
    Set<String> interests;
}