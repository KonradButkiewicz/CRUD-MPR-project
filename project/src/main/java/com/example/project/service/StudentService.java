package com.example.project.service;

import com.example.project.model.Course;
import com.example.project.model.Student;
import com.example.project.model.dto.StudentDTO;
import com.example.project.model.dto.mapper.student.StudentCreate;
import com.example.project.model.dto.mapper.student.StudentEdit;
import com.example.project.model.dto.mapper.student.StudentRead;
import com.example.project.model.exceptions.global.CreationException;
import com.example.project.model.exceptions.global.NotAllowedOperationException;
import com.example.project.model.exceptions.service.StudentNotFoundException;
import com.example.project.repository.CourseRepository;
import com.example.project.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Transactional
    public String createStudent(StudentDTO studentDTO, Long id) {
        try {
            Student student = StudentCreate.toEntity(studentDTO);

            Course course = courseRepository.findById(id).get();

            student.setCourse(course);

            studentRepository.save(student);

            return "Student created";
        }catch (Exception e) {
            throw new CreationException("Error creating student: " + e.getMessage());
        }
    }

    @Transactional
    public String editStudent(StudentDTO studentDTO, Student student) {
        try {
            student = StudentEdit.toEntity(student, studentDTO);
            studentRepository.save(student);

            return "Student edited";
        }catch (Exception e){
        throw new RuntimeException("Edit failed", e);
        }
    }

    public List<StudentDTO> getAllStudents() {
        List<StudentDTO> studentDTOList = new ArrayList<>();
        studentRepository.findAll().forEach(s -> studentDTOList.add(StudentRead.toDTO(s)));

        return studentDTOList;
    }

    public List<StudentDTO> getStudentByBirthYear(Integer birthYear) {
        if(birthYear < 0){
            throw new NotAllowedOperationException();
        }
        List<StudentDTO> studentDTOList = new ArrayList<>();
        studentRepository.findStudentByBirthYear(birthYear)
                .forEach(s -> studentDTOList.add(StudentRead.toDTO(s)));

        return studentDTOList;
    }

    public Integer getLowestBirthYear() {
        return studentRepository.findLowestBirhtYear().orElse(null);
    }

    public StudentDTO findByID(Long studentId) {
        if(studentId < 0){
            throw new NotAllowedOperationException();
        }
        return StudentRead.toDTO(studentRepository.findById(studentId).stream().findFirst()
                .orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + studentId)));
    }
}
