package com.example.project.model.dto.mapper.course;

import com.example.project.model.Course;
import com.example.project.model.dto.CourseDTO;

public class CourseEdit {
    public static Course toEntity(Course course, CourseDTO courseDTO){
        course.setId(courseDTO.getId());
        course.setName(courseDTO.getName());
        course.setBuilding(courseDTO.getBuilding());
        course.setRoomNumber(courseDTO.getRoomNumber());
        course.setStudentsList(courseDTO.getStudentsList());

        return course;
    }
}
