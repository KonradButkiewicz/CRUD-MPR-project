package com.example.project.model.dto.mapper.student;

import com.example.project.model.Student;
import com.example.project.model.dto.StudentDTO;

public class StudentRead {
    public static StudentDTO toDTO(Student student){
        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setLastname(student.getLastname());
        studentDTO.setBirthYear(student.getBirthYear());
        studentDTO.setGender(student.getGender());
        studentDTO.setCourse(student.getCourse());

        return studentDTO;
    }
}
