package com.example.demo.Controller;

import com.example.demo.Enity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface RegisterRepository extends JpaRepository <Registration,Long> {
    @Transactional
    @Modifying
    @Query(value = "insert into course_student_info(course_id,student_info_id) values (?1,?2)",nativeQuery = true)
    int insert(String cid,int sid);

    @Transactional
    @Modifying
    @Query(value = "update student_info set student_class = ?2 where sid = ?1",nativeQuery = true)
    int updateStu(String sid,int cid);

}
