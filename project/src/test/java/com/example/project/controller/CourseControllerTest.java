package com.example.project.controller;

import com.example.project.controller.CourseController;
import com.example.project.model.dto.CourseDTO;
import com.example.project.service.CourseService;
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

public class CourseControllerTest {

    @Mock
    private CourseService courseService;

    @InjectMocks
    private CourseController courseController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(courseController).build();
    }

    @Test
    void getAllCourses() throws Exception {
        when(courseService.getAllCourses()).thenReturn(Arrays.asList(new CourseDTO(), new CourseDTO()));

        mockMvc.perform(get("/course/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void addCourse() throws Exception {
        when(courseService.createCourse(any())).thenReturn("Course created");

        ResultActions result = mockMvc.perform(post("/course/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"));

        result.andExpect(status().isCreated());
    }

    @Test
    void editCourse() throws Exception {
        when(courseService.findByID(any())).thenReturn(new CourseDTO());
        when(courseService.editCourse(any(), any())).thenReturn("Course edited");

        ResultActions result = mockMvc.perform(put("/course/edit/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"));

        result.andExpect(status().isCreated());
    }

    @Test
    void deleteRoomsBelowNumber200() throws Exception {
         ResultActions result = mockMvc.perform(post("/course/delete"));

        result.andExpect(status().isOk());
    }
}
