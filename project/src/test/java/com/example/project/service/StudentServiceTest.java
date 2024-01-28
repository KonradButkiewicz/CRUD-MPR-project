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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private CourseRepository courseRepository;

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    public void testCreateStudent() {
        StudentDTO studentDTO = new StudentDTO();

        when(courseRepository.findById(any())).thenReturn(Optional.of(new Course()));

        assertEquals("Student created", studentService.createStudent(studentDTO, 1L));
    }

    @Test
    public void testEditStudent() {
        Student student = new Student();
        StudentDTO studentDTO = new StudentDTO();

        assertEquals("Student edited", studentService.editStudent(studentDTO, student));
    }

    @Test
    public void testGetAllStudents() {
        List<Student> studentList = new ArrayList<>();
        when(studentRepository.findAll()).thenReturn(studentList);

        List<StudentDTO> result = studentService.getAllStudents();

        assertEquals(0, result.size());
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    public void testGetStudentByBirthYear() {
        List<Student> studentList = new ArrayList<>();
        when(studentRepository.findStudentByBirthYear(anyInt())).thenReturn(studentList);

        List<StudentDTO> result = studentService.getStudentByBirthYear(1990);

        assertEquals(0, result.size());
        verify(studentRepository, times(1)).findStudentByBirthYear(1990);
    }

    @Test
    public void testGetLowestBirthYear() {
        when(studentRepository.findLowestBirhtYear()).thenReturn(Optional.of(1990));

        Integer result = studentService.getLowestBirthYear();

        assertEquals(1990, result.intValue());
        verify(studentRepository, times(1)).findLowestBirhtYear();
    }

    @Test
    public void testFindByIDNotFound() {
        Long studentId = 1L;
        when(studentRepository.findById(studentId)).thenReturn(Optional.empty());

        assertThrows(StudentNotFoundException.class, () -> studentService.findByID(studentId));
        verify(studentRepository, times(1)).findById(studentId);
    }
}
