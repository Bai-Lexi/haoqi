package com.example.demo.DataProxy;

import com.example.demo.Controller.CourseRepository;
import com.example.demo.Controller.InvestigationRecordRepository;
import com.example.demo.Controller.InvestigationRepository;
import com.example.demo.Controller.PaymentRepository;
import com.example.demo.Enity.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.erupt.annotation.fun.DataProxy;
@Service
public class CourseDataProxy implements DataProxy<Course> {
    @Autowired
    InvestigationRecordRepository inv;
    @Autowired
    CourseRepository cor;

    @Autowired
    InvestigationRepository inve;

    @Autowired
    PaymentRepository paymentRepository;
    @Override
    public void afterAdd(Course course) {
        String tname = cor.findTname(course.getCourse_id());
        inv.save(course.getCourse_id(),"0",tname,"0","0");
        String pay = cor.findSumPay(course.getCourse_teacher());
        String count = cor.findCaccount(course.getCourse_teacher());
        paymentRepository.update(course.getCourse_teacher(),count,pay);
    }

    @Override
    public void afterDelete(Course c) {
        inve.delInve(c.getCourse_id());
        inv.delInv(c.getCourse_id());
        String count = cor.findCaccount(c.getCourse_teacher());
        if(!count.equals("0")){
            String pay = cor.findSumPay(c.getCourse_teacher());
            paymentRepository.update(c.getCourse_teacher(),count,pay);
        }else{
            paymentRepository.update(c.getCourse_teacher(),"0","0");
        }
    }
}
