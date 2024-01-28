package com.example.project.model.dto;

import com.example.project.model.Course;
import com.example.project.model.enums.Gender;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class StudentDTO {
    private Long id;

    @NotBlank(message = "Name can not be null")
    private String name;

    @NotBlank(message = "Last name can not be null")
    private String lastname;

    @NotNull(message = "Birth year can not be null")
    private Integer birthYear;

    @NotNull(message = "Gender can not be null")
    private Gender gender;

    @JsonProperty("course")
    private CourseDTO courseDTO;
}
