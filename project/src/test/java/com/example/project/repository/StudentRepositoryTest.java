package com.example.project.repository;

import com.example.project.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testFindStudentByBirthYear(){
        Student student = new Student();

        student.setBirthYear(2002);

        studentRepository.save(student);

        assertEquals(student, studentRepository.findStudentByBirthYear(2002).stream().findFirst().orElse(null));
    }

    @Test
    public void testFindLoewstBirthYear(){
        Student student = new Student();
        Student student1 = new Student();

        student.setBirthYear(2002);
        student1.setBirthYear(2003);

        studentRepository.save(student);
        studentRepository.save(student1);

        assertEquals(student.getBirthYear(), studentRepository.findLowestBirhtYear().stream().findFirst().orElse(null));
    }
}
