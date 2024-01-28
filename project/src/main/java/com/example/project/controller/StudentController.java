package com.example.project.controller;

import com.example.project.model.dto.StudentDTO;
import com.example.project.model.dto.mapper.student.StudentCreate;
import com.example.project.service.CourseService;
import com.example.project.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
@CrossOrigin
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCourse(@RequestBody @Validated StudentDTO studentDTO , @PathVariable Long id) {
        studentService.createStudent(studentDTO, id);
    }

    @PutMapping("/{id}/{courseId}")
    @ResponseStatus(HttpStatus.OK)
    public void editStudent(@RequestBody @Validated StudentDTO studentDTO, @PathVariable Long id, @PathVariable Long courseId) {
        studentService.editStudent(studentDTO, StudentCreate.toEntity(studentService.findByID(id)), courseId);
    }

    @GetMapping("/birthyear")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentDTO> getStudentByBirthYear(@RequestParam Integer birthYear){
        return studentService.getStudentByBirthYear(birthYear);
    }

    @GetMapping("/lowestbirthyear")
    @ResponseStatus(HttpStatus.OK)
    public Integer getLowestBirthYear(){
        return studentService.getLowestBirthYear();
    }




}
