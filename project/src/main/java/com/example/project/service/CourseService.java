package com.example.project.service;

import com.example.project.model.Course;
import com.example.project.model.dto.CourseDTO;
import com.example.project.model.dto.mapper.course.CourseCreate;
import com.example.project.model.dto.mapper.course.CourseEdit;
import com.example.project.model.dto.mapper.course.CourseRead;
import com.example.project.model.exceptions.global.CreationException;
import com.example.project.model.exceptions.global.NotAllowedOperationException;
import com.example.project.model.exceptions.service.CourseNotFoundException;
import com.example.project.repository.CourseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    @Transactional
    public String createCourse(CourseDTO courseDTO) {
        try {
            Course courseCreate = CourseCreate.toEntity(courseDTO);
            courseRepository.save(courseCreate);
            return "Course created";
        }catch (Exception e) {
            throw new CreationException("Error creating student: " + e.getMessage());
        }
    }

    @Transactional
    public String editCourse(CourseDTO courseDTO, Course course) {
        try{
            Course courseEdit = CourseEdit.toEntity(course, courseDTO);

            courseRepository.save(courseEdit);
            return "Course edited";
        }catch (Exception e){
            throw new RuntimeException("Edit failed", e);
        }
    }

    public List<CourseDTO> getAllCourses() {
        List<CourseDTO> courseDTOList = new ArrayList<>();
        courseRepository.findAll().forEach(c -> courseDTOList.add(CourseRead.toDTO(c)));
        return courseDTOList;
    }

    public void deleteRoomsBelowNumber200() {
        courseRepository.deleteRoomsBelowNumber200();
    }

    public CourseDTO findByID(Long courseId) {
        if(courseId < 0){
            throw new NotAllowedOperationException();
        }
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with ID: " + courseId));

        return CourseRead.toDTO(course);
    }
}
