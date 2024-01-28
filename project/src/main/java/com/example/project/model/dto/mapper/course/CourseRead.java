package com.example.project.model.dto.mapper.course;

import com.example.project.model.Course;
import com.example.project.model.Student;
import com.example.project.model.dto.CourseDTO;
import com.example.project.model.dto.StudentDTO;
import com.example.project.model.dto.mapper.student.StudentRead;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class CourseRead {
    public static CourseDTO toDTO(Course course){
        CourseDTO courseDTO = new CourseDTO();

        BeanUtils.copyProperties(course, courseDTO);

        return courseDTO;
    }

}
