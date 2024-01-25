package com.example.project.model.dto.mapper.course;

import com.example.project.model.Course;
import com.example.project.model.dto.CourseDTO;

public class CourseCreate {
    public static Course toEntity(CourseDTO courseDTO){
        Course course = new Course();

        course.setId(courseDTO.getId());
        course.setName(courseDTO.getName());
        course.setBuilding(courseDTO.getBuilding());
        course.setRoomNumber(courseDTO.getRoomNumber());
        course.setStudentsList(courseDTO.getStudentsList());

        return course;
    }
}
