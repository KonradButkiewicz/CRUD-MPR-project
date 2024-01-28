package com.example.project.model.dto.mapper.student;

import com.example.project.model.Student;
import com.example.project.model.dto.StudentDTO;
import com.example.project.model.dto.mapper.course.CourseRead;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

public class StudentRead {
    public static StudentDTO toDTO(Student student){
        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setLastname(student.getLastname());
        studentDTO.setBirthYear(student.getBirthYear());
        studentDTO.setGender(student.getGender());
        studentDTO.setCourseDTO(CourseRead.toDTO(student.getCourse()));

        return studentDTO;
    }
}
