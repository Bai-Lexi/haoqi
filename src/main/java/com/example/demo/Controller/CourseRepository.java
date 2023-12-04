package com.example.demo.Controller;

import com.example.demo.Enity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT c.course_pay FROM Course c")
    List<Course> findAllCoursesWithPay();

    @Query("SELECT SUM(c.course_pay) FROM Course c")
    Double getTotalCoursePay();
}
