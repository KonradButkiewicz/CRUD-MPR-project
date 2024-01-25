package com.example.project.controller;

import com.example.project.model.dto.StudentDTO;
import com.example.project.model.dto.mapper.student.StudentCreate;
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

    @GetMapping("/getall")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCourse(@RequestBody @Validated StudentDTO studentDTO) {
        studentService.createStudent(studentDTO);
    }

    @PostMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void editStudent(@RequestBody @Validated StudentDTO studentDTO, @PathVariable Long id) {
        studentService.editStudent(studentDTO, StudentCreate.toEntity(studentService.findByID(id)));
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