package com.example.demo.Controller;

import com.example.demo.Enity.InvestigationRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface InvestigationRecordRepository extends JpaRepository<InvestigationRecord,Long> {
    @Modifying
    @Query(value = "insert into investigation_record(course_id,course_score,teacher,teacher_score,num) values(?1,?2,?3,?4,?5)",nativeQuery = true)
    int save(String course_id,String course_score,String teacher,String teacher_score ,String num);

    @Modifying
    @Query(value  = "update investigation_record set course_score=?2,teacher_score=?3,num=?4 where course_id=?1",nativeQuery = true)
    int update(String cid,String cs,String ts,String num);


    @Query(value="select course_score from investigation_record where course_id=?1",nativeQuery = true)
    String  getCs(String cid);


    @Query(value="select teacher_score from investigation_record where course_id=?1",nativeQuery = true)
    String  getTs(String cid);


    @Query(value="select num from investigation_record where course_id=?1",nativeQuery = true)
    String  getNum(String cid);
    @Transactional
    @Modifying
    @Query(value = "delete from investigation_record where course_id =?",nativeQuery = true)
    int delInv(String cid);
}
