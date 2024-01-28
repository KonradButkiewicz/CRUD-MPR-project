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
        when(studentService.getAllStudents()).thenReturn(Arrays.asList(new StudentDTO(), new StudentDTO()));

        mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void addCourse() throws Exception {
        when(studentService.createStudent(any())).thenReturn("Student created");

        ResultActions result = mockMvc.perform(post("/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"));

        result.andExpect(status().isCreated());
    }

    @Test
    void editStudent() throws Exception {
        when(studentService.findByID(any())).thenReturn(new StudentDTO());
        when(studentService.editStudent(any(), any())).thenReturn("Student edited");

        ResultActions result = mockMvc.perform(put("/students/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"));

        result.andExpect(status().isOk());
    }

    @Test
    void getStudentByBirthYear() throws Exception {
        when(studentService.getStudentByBirthYear(any())).thenReturn(Collections.singletonList(new StudentDTO()));

        mockMvc.perform(get("/students/birthyear").param("birthYear", "1990"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(1));
    }

    @Test
    void getLowestBirthYear() throws Exception {
        when(studentService.getLowestBirthYear()).thenReturn(1990);

        mockMvc.perform(get("/students/lowestbirthyear"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(1990));
    }
}

