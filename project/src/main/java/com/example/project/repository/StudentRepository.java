package com.example.project.repository;

import com.example.project.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findStudentByBirthYear(Integer birth_year);

    @Query("SELECT min(s.birthYear) FROM Student s")
    Optional<Integer> findLowestBirhtYear();
}
