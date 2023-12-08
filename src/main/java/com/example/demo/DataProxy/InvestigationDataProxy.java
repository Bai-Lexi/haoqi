package com.example.demo.DataProxy;

import com.example.demo.Controller.InvestigationRecordRepository;
import com.example.demo.Controller.InvestigationRepository;
import com.example.demo.Enity.Investigation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.erupt.annotation.fun.DataProxy;
import xyz.erupt.core.exception.EruptApiErrorTip;
@Service
public class InvestigationDataProxy implements DataProxy<Investigation> {

    @Autowired
    InvestigationRecordRepository investigationRecordRepository;

    @Autowired
    InvestigationRepository invs;

    @Override public void afterAdd(Investigation inv){
        String cid = inv.getCourse_id();
        double cs = invs.findAvgCs(cid);
        double ts = invs.findAvgTs(cid);
        double num = invs.findNum(cid);
        investigationRecordRepository.update(cid,String.valueOf(cs),String.valueOf(ts),String.valueOf(num));
    }

    @Transactional
    @Override public void afterDelete(Investigation inv){
        String cid = inv.getCourse_id();
        double num = invs.findNum(cid);
        if(num!=0){
            double cs = invs.findAvgCs(cid);
            double ts = invs.findAvgTs(cid);

            investigationRecordRepository.update(cid,String.valueOf(cs),String.valueOf(ts),String.valueOf(num));
        }
        else{
            investigationRecordRepository.update(cid,"0","0","0");
        }
    }
}
