package com.example.project.controller;

import com.example.project.model.Course;
import com.example.project.model.dto.CourseDTO;
import com.example.project.model.dto.mapper.course.CourseCreate;
import com.example.project.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/course")
@CrossOrigin
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CourseDTO> getAllCourses(){
        return courseService.getAllCourses();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCourse(@RequestBody @Validated CourseDTO courseDTO){
        courseService.createCourse(courseDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void editCourse(@RequestBody @Validated CourseDTO courseDTO, @PathVariable Long id) {
        courseService.editCourse(courseDTO, CourseCreate.toEntity(courseService.findByID(id)));
    }


    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void delete(){
        courseService.deleteRoomsBelowNumber200();
    }
}


