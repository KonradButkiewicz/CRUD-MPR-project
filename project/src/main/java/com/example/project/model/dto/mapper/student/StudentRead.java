package com.example.project.model.dto.mapper.student;

import com.example.project.model.Student;
import com.example.project.model.dto.StudentDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

public class StudentRead {
    public static StudentDTO toDTO(Student student){
        StudentDTO studentDTO = new StudentDTO();

        BeanUtils.copyProperties(student, studentDTO);

        return studentDTO;
    }
}
