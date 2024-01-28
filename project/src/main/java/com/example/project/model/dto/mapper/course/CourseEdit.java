package com.example.project.model.dto.mapper.course;

import com.example.project.model.Course;
import com.example.project.model.Student;
import com.example.project.model.dto.CourseDTO;
import com.example.project.model.dto.StudentDTO;
import com.example.project.model.dto.mapper.student.StudentCreate;
import com.example.project.model.dto.mapper.student.StudentRead;

import java.util.List;
import java.util.stream.Collectors;

public class CourseEdit {
    public static Course toEntity(Course course, CourseDTO courseDTO) {

        course.setId(courseDTO.getId());
        course.setName(courseDTO.getName());
        course.setBuilding(courseDTO.getBuilding());
        course.setRoomNumber(courseDTO.getRoomNumber());

        return course;
    }
}

