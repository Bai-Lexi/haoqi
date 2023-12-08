package com.example.demo.Controller;

import com.example.demo.Enity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
    @Transactional
    @Modifying
    @Query(value = "insert into payment (tid,tname,caccount,pay) values (?1,?2,?3,?4)",nativeQuery = true)
    int insertpay(String tid,String tname , String num,String pay);
    @Transactional
    @Modifying
    @Query(value = "update payment set caccount=?2,pay=?3 where tid = ?1",nativeQuery = true)
    int update(String tid,String num,String pay);

    @Transactional
    @Modifying
    @Query(value = "delete from payment where tid = ?1",nativeQuery = true)
    int delPay(String tid);
}
