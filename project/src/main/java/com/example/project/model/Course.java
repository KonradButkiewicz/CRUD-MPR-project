package com.example.project.model;

import com.example.project.model.enums.Building;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer roomNumber;

    @Enumerated(EnumType.STRING)
    private Building building;

}
