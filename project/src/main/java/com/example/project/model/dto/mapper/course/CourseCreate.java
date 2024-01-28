package com.example.project.model.dto.mapper.course;

import com.example.project.model.Course;
import com.example.project.model.Student;
import com.example.project.model.dto.CourseDTO;
import com.example.project.model.dto.StudentDTO;
import com.example.project.model.dto.mapper.student.StudentCreate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CourseCreate {
    public static Course toEntity(CourseDTO courseDTO) {
        Course course = new Course();

        course.setId(courseDTO.getId());
        course.setName(courseDTO.getName());
        course.setBuilding(courseDTO.getBuilding());
        course.setRoomNumber(courseDTO.getRoomNumber());

        return course;
    }
}
