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
import xyz.erupt.toolkit.handler.SqlChoiceFetchHandler;
import xyz.erupt.upms.model.base.HyperModel;
import xyz.erupt.jpa.model.BaseModel;
import java.util.Set;
import java.util.Date;

@Erupt(name = "Course", power = @Power(importable = true, export = true))
@Table(name = "Course")
@Entity
public class Course extends BaseModel {

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
                    title = "时间"
            ),
            edit = @Edit(
                    title = "时间",
                    type = EditType.DATE, search = @Search, notNull = true,
                    dateType = @DateType(type = DateType.Type.DATE_TIME)
            )
    )
    private Date course_time;

    @EruptField(
            views = @View(
                    title = "地点"
            ),
            edit = @Edit(
                    title = "地点",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String course_place;

//    @EruptField(
//            views = @View(
//                    title = "任课教师"
//            ),
//            edit = @Edit(
//                    title = "任课教师",
//                    type = EditType.TAB_TABLE_REFER, search = @Search, notNull = true
//            )
//    )
//    @ManyToMany
//    @JoinTable(name = "course_teacher_info",
//            joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "teacher_info_id", referencedColumnName = "id"))
//    private Set<TeacherInfo> course_teacher;
    @EruptField(
            views = @View(
                    title = "任课教师"
            ),
            edit = @Edit(
                    search = @Search,
                    title = "任课教师",
                    type = EditType.CHOICE,  notNull = true,
                    choiceType = @ChoiceType(
                            fetchHandler = SqlChoiceFetchHandler.class,
                            //参数一必填，表示sql语句
                            //参数二可不填，表示缓存时间，默认为3000毫秒，1.6.10及以上版本支持
                            fetchHandlerParams = {"select id, tname from teacher_info", "5000"}
                    )
            )
    )
    private String course_teacher;


    @EruptField(
            views = @View(
                    title = "培训内容"
            ),
            edit = @Edit(
                    title = "培训内容",
                    type = EditType.INPUT, search = @Search,
                    inputType = @InputType
            )
    )
    private String course_content;

    @EruptField(
            views = @View(
                    title = "费用"
            ),
            edit = @Edit(
                    title = "费用",
                    type = EditType.NUMBER, search = @Search, notNull = true,
                    numberType = @NumberType
            )
    )
    private Integer course_pay;

    @EruptField(
            views = @View(
                    title = "委托方"
            ),
            edit = @Edit(
                    title = "委托方",
                    type = EditType.TAB_TABLE_REFER, search = @Search
            )
    )
    @ManyToMany
    @JoinTable(name = "course_apply",
            joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "apply_id", referencedColumnName = "id"))
    private Set<Apply> course_client;

    @EruptField(
            views = @View(
                    title = "学员信息"
            ),
            edit = @Edit(
                    title = "学员信息",
                    type = EditType.TAB_TABLE_REFER, search = @Search
            )
    )
    @ManyToMany
    @JoinTable(name = "course_student_info",
            joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_info_id", referencedColumnName = "id"))
    private Set<StudentInfo> course_students;
}