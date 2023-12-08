package com.example.demo.Enity;

/*
 * Copyright © 2020-2035 erupt.xyz All rights reserved.
 * Author: YuePeng (erupts@126.com)
 */

import javax.persistence.*;
import xyz.erupt.annotation.*;
import xyz.erupt.annotation.sub_erupt.*;
import xyz.erupt.annotation.sub_field.*;
import xyz.erupt.annotation.sub_field.sub_edit.*;
import xyz.erupt.upms.model.base.HyperModel;
import xyz.erupt.jpa.model.BaseModel;
import java.util.Set;
import java.util.Date;

@Erupt(name = "Payment")
@Table(name = "Payment")
@Entity
public class Payment extends BaseModel {

    @EruptField(
            views = @View(
                    title = "教师编号"
            ),
            edit = @Edit(
                    title = "教师编号",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String tid;

    @EruptField(
            views = @View(
                    title = "教师姓名"
            ),
            edit = @Edit(
                    title = "教师姓名",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String tname;

    @EruptField(
            views = @View(
                    title = "课程数量"
            ),
            edit = @Edit(
                    title = "课程数量",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String caccount;

    @EruptField(
            views = @View(
                    title = "总收入"
            ),
            edit = @Edit(
                    title = "总收入",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String pay;

}