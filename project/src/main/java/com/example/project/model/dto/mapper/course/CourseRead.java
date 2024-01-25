package com.example.project.model.dto.mapper.course;

import com.example.project.model.Course;
import com.example.project.model.Student;
import com.example.project.model.dto.CourseDTO;

public class CourseRead {
    public static CourseDTO toDTO(Course course){
        CourseDTO courseDTO = new CourseDTO();

        courseDTO.setId(course.getId());
        courseDTO.setName(course.getName());
        courseDTO.setBuilding(course.getBuilding());
        courseDTO.setRoomNumber(course.getRoomNumber());
        courseDTO.setStudentsList(course.getStudentsList());

        return courseDTO;
    }

}
