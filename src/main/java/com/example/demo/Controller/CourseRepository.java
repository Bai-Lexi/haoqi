package com.example.demo.Controller;

import com.example.demo.Enity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT c.course_pay FROM Course c")
    List<Course> findAllCoursesWithPay();

    @Query("SELECT SUM(c.course_pay) FROM Course c")
    Double getTotalCoursePay();

    @Query(value = "SELECT t.tname FROM Teacher_info t  LEFT JOIN course c ON t.tid = c.course_teacher where c.COURSE_id =?",nativeQuery = true)
    String findTname(String cid);


    @Query(value = "select sum(course_pay) from course where course_teacher = ?",nativeQuery = true)
    String findSumPay(String tid);

    @Query(value = "select count(*) from course where course_teacher = ?",nativeQuery = true)
    String findCaccount(String tid);

}
