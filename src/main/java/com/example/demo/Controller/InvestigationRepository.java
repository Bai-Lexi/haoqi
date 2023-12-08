package com.example.demo.Controller;

import com.example.demo.Enity.Investigation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface InvestigationRepository extends JpaRepository<Investigation, Long> {

//    // 查询每个老师的平均评分，包含教师名
//    @Query("SELECT course_teacher1, AVG(score) AS avgScore FROM Investigation GROUP BY course_teacher1")
//    List<Object[]> findAverageScoreByTeacher();
// 查询每个老师的平均评分和相关信息
    @Query("SELECT t.tname, AVG(i.score) AS avgScore " +
            "FROM TeacherInfo t " +
            "LEFT JOIN Investigation i ON t.tid = i.course_teacher1 " +
            "GROUP BY t.tname")
    List<Object[]> findAverageScoreByTeacher();

    // 查询每门课程的平均评分，包含课程号
    @Query("SELECT course_id, AVG(rate) AS avgRate FROM Investigation GROUP BY course_id")
    List<Object[]> findAverageRateByCourse();

    @Query(value = "SELECT AVG(rate)  FROM Investigation where course_id=?",nativeQuery = true)
    double findAvgCs(String cid);

    @Query(value = "SELECT AVG(score)  FROM Investigation where course_id=?",nativeQuery = true)
    double findAvgTs(String cid);

    @Query(value = "SELECT count(*)  FROM Investigation where course_id=?",nativeQuery = true)
    double findNum(String cid);

    @Transactional
    @Modifying
    @Query(value = "delete from investigation where course_id =?",nativeQuery = true)
    int delInve(String cid);



}

