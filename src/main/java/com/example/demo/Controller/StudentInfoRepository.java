package com.example.demo.Controller;

import com.example.demo.Enity.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentInfoRepository extends JpaRepository <StudentInfo,Long>{

    @Query(value="select id from student_info where sname=?1",nativeQuery = true)
    int  getSid(String sname);

    @Query(value="select course_id from registration_course where registration_id=?1",nativeQuery = true)
    int  getCid(int rid);


    @Query(value="select id from registration  where sname=?1 order by id desc limit 1",nativeQuery = true)
    int getRid(String sname);

    @Query(value="select course_id from course where id=?1",nativeQuery = true)
    String  getCourse_id(int cid);

    @Query(value="select sid from student_info where sname=?1",nativeQuery = true)
    String  getxuehao(String sname);

}
