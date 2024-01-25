package com.example.project.controller;

import com.example.project.model.dto.StudentDTO;
import com.example.project.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.Arrays;
import java.util.Collections;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class StudentControllerTest {

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
    }

    @Test
    void getAllStudents() throws Exception {
        // Mocking the service to return a list of students
        when(studentService.getAllStudents()).thenReturn(Arrays.asList(new StudentDTO(), new StudentDTO()));

        // Performing the request and validating the response
        mockMvc.perform(get("/students/getall"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void addCourse() throws Exception {
        // Mocking the service to return a success message
        when(studentService.createStudent(any())).thenReturn("Student created");

        // Performing the request and validating the response
        ResultActions result = mockMvc.perform(post("/students/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"));

        result.andExpect(status().isCreated());
    }

    @Test
    void editStudent() throws Exception {
        // Mocking the service to return a success message
        when(studentService.findByID(any())).thenReturn(new StudentDTO());
        when(studentService.editStudent(any(), any())).thenReturn("Student edited");

        // Performing the request and validating the response
        ResultActions result = mockMvc.perform(post("/students/edit/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"));

        result.andExpect(status().isOk());
    }

    @Test
    void getStudentByBirthYear() throws Exception {
        // Mocking the service to return a list of students
        when(studentService.getStudentByBirthYear(any())).thenReturn(Collections.singletonList(new StudentDTO()));

        // Performing the request and validating the response
        mockMvc.perform(get("/students/birthyear").param("birthYear", "1990"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(1));
    }

    @Test
    void getLowestBirthYear() throws Exception {
        // Mocking the service to return the lowest birth year
        when(studentService.getLowestBirthYear()).thenReturn(1990);

        // Performing the request and validating the response
        mockMvc.perform(get("/students/lowestbirthyear"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(1990));
    }
}

