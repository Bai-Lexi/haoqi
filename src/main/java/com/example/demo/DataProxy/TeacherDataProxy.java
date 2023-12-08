package com.example.demo.DataProxy;

import com.example.demo.Controller.PaymentRepository;
import com.example.demo.Enity.Investigation;
import com.example.demo.Enity.Payment;
import com.example.demo.Enity.Registration;
import com.example.demo.Enity.TeacherInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.erupt.annotation.fun.DataProxy;
@Service
public class TeacherDataProxy implements DataProxy<TeacherInfo> {

    @Autowired
    PaymentRepository payment;
    @Override
    public void afterAdd(TeacherInfo tea) {
        payment.insertpay(tea.getTid(),tea.getTname(),"0","0");
    }

    @Override
    public void afterDelete(TeacherInfo tea){
        payment.delPay(tea.getTid());
    }
}
