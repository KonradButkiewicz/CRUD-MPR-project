package com.example.project.model.dto;

import com.example.project.model.Student;
import com.example.project.model.enums.Building;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class  CourseDTO {
    private Long id;

    @NotBlank(message = "Name can not be null")
    private String name;

    @NotNull(message = "Building can not be null")
    private Building building;

    @NotNull(message = "Room number can not be null")
    private Integer roomNumber;
}
