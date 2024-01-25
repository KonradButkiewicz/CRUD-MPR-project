package com.example.project.service;
import com.example.project.model.Course;
import com.example.project.model.dto.CourseDTO;
import com.example.project.repository.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CourseServiceTest {
     @Mock
        private CourseRepository courseRepository;

     @InjectMocks
        private CourseService courseService;

     @BeforeEach
     public void setUP(){
         openMocks(this);
     }
     @Test
        public void testCreateCourse(){
         CourseDTO courseDTO = new CourseDTO();

         assertEquals("Course created", courseService.createCourse(courseDTO));
     }
     @Test
        public void testEditCourse(){
         Course course = new Course();
         CourseDTO courseDTO = new CourseDTO();

         assertEquals("Course edited", courseService.editCourse(courseDTO, course));
     }

}


