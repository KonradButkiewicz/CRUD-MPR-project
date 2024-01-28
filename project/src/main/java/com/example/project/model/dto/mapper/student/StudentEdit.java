package com.example.project.model.dto.mapper.student;

import com.example.project.model.Student;
import com.example.project.model.dto.StudentDTO;

public class StudentEdit {
    public static Student toEntity(Student student, StudentDTO studentDTO){
        student.setId(studentDTO.getId());
        student.setName(studentDTO.getName());
        student.setLastname(studentDTO.getLastname());
        student.setBirthYear(studentDTO.getBirthYear());
        student.setGender(studentDTO.getGender());

        return student;
    }
}
