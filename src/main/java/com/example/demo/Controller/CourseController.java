package com.example.demo.Controller;

import com.example.demo.Enity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/totalPay")
    public Double getTotalCoursePay() {
        return courseRepository.getTotalCoursePay();
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseRepository.findAllCoursesWithPay();
    }
}
