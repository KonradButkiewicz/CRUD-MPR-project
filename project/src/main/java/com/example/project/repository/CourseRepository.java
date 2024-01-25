package com.example.project.repository;

import com.example.project.model.Course;
import com.example.project.model.Student;
import com.example.project.model.enums.Building;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findCourseByRoomNumber(Integer roomNumber);

    @Query("DELETE FROM Course c where c.roomNumber < 200")
    @Modifying
    @Transactional
    void deleteRoomsBelowNumber200();

    @Query("SELECT s FROM Student s JOIN s.course c WHERE c.building = ?1")
    List<Student> findStudentsByBuildingNumber(Building buildingNumber);
}


