package com.example.project.repository;

import com.example.project.model.Course;
import com.example.project.model.Student;
import com.example.project.model.enums.Building;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testfindByRoomNumber(){
        Course course = new Course();

        course.setRoomNumber(1);
        course.setName("MPR");

        courseRepository.save(course);

        assertEquals(course.getName(), courseRepository.findCourseByRoomNumber(1).stream().findFirst().orElse(null).getName());
    }

    @Test
    public void testDeleteRoomsBelowNumber200(){
        Course course = new Course();
        Course course1 = new Course();

        course.setRoomNumber(50);
        course1.setRoomNumber(100);

        courseRepository.save(course);
        courseRepository.save(course1);

        courseRepository.deleteRoomsBelowNumber200();

        assertEquals(null, courseRepository.findAll().stream().findFirst().orElse(null));
    }

    @Test
    public void testFindStudentsByBuildingNumber(){
        Course course = new Course();
        Student student = new Student();
        student.setCourse(course);

        List<Student> studentList = List.of(student);


        course.setBuilding(Building.A1);

        courseRepository.save(course);
        studentRepository.save(student);

        List<Student> studentList1 = courseRepository.findStudentsByBuildingNumber(Building.A1);

        assertEquals(studentList1, studentList);
    }
}
