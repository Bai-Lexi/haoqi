package com.example.demo.DataProxy;

import com.example.demo.Controller.CourseRepository;
import com.example.demo.Controller.RegisterRepository;
import com.example.demo.Controller.StudentInfoRepository;
import com.example.demo.Enity.Course;
import com.example.demo.Enity.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.erupt.annotation.fun.DataProxy;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
@Service
public class RegistDataProxy  implements DataProxy<Registration> {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentInfoRepository studentInfoRepository;

    @Autowired
    RegisterRepository registerRepository;
    @Override
    public void afterAdd(Registration reg) {
        int rid = studentInfoRepository.getRid(reg.getSname());
        int cid = studentInfoRepository.getCid(rid);
        String course_id = studentInfoRepository.getCourse_id(cid);
        int sid = studentInfoRepository.getSid(reg.getSname());
        registerRepository.insert(course_id,sid);
        String xuehao  = studentInfoRepository.getxuehao(reg.getSname());
        registerRepository.updateStu(xuehao,cid);
    }
}
