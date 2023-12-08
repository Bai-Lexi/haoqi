package com.example.demo.Enity;

/*
 * Copyright © 2020-2035 erupt.xyz All rights reserved.
 * Author: YuePeng (erupts@126.com)
 */

import javax.persistence.*;

import xyz.erupt.annotation.*;
import xyz.erupt.annotation.sub_field.*;
import xyz.erupt.annotation.sub_field.sub_edit.*;
import xyz.erupt.jpa.model.BaseModel;

/*
 * Copyright © 2020-2035 erupt.xyz All rights reserved.
 * Author: YuePeng (erupts@126.com)
 */

@Erupt(name = "InvestigationRecord" )
@Table(name = "InvestigationRecord")
@Entity
public class InvestigationRecord extends BaseModel {
    public String getCourse_score() {
        return course_score;
    }

    public String getTeacher_score() {
        return teacher_score;
    }

    public String getNum() {
        return num;
    }

    @EruptField(
            views = @View(
                    title = "课程号"
            ),
            edit = @Edit(
                    title = "课程号",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String course_id;

    @EruptField(
            views = @View(
                    title = "课程评价"
            ),
            edit = @Edit(
                    title = "课程评价",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String course_score;

    @EruptField(
            views = @View(
                    title = "任课教师"
            ),
            edit = @Edit(
                    title = "任课教师",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String teacher;

    @EruptField(
            views = @View(
                    title = "教师评分"
            ),
            edit = @Edit(
                    title = "教师评分",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String teacher_score;

    @EruptField(
            views = @View(
                    title = "评教人数"
            ),
            edit = @Edit(
                    title = "评教人数",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String num;

}