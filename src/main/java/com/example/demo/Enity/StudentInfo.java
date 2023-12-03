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

@Erupt(name = "StudentInfo")
@Table(name = "StudentInfo")
@Entity
public class StudentInfo extends BaseModel {

    @EruptField(
            views = @View(
                    title = "学号"
            ),
            edit = @Edit(
                    title = "学号",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String sid;

    @EruptField(
            views = @View(
                    title = "学员姓名"
            ),
            edit = @Edit(
                    title = "学员姓名",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String sname;

    @EruptField(
            views = @View(
                    title = "电话"
            ),
            edit = @Edit(
                    title = "电话",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String sphone;

    @EruptField(
            views = @View(
                    title = "邮箱"
            ),
            edit = @Edit(
                    title = "邮箱",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String semail;

    @EruptField(
            views = @View(
                    title = "意向方向"
            ),
            edit = @Edit(
                    title = "意向方向",
                    type = EditType.CHOICE,
                    choiceType = @ChoiceType(
                            fetchHandler = SqlChoiceFetchHandler.class,
                            //参数一必填，表示sql语句
                            //参数二可不填，表示缓存时间，默认为3000毫秒，1.6.10及以上版本支持
                            fetchHandlerParams = {"select id, domain from teacher_info", "5000"}
                    )
            )
    )
    private String shobby;

//    @EruptField(
//            views = @View(
//                    title = "所在班级"
//            ),
//            edit = @Edit(
//                    title = "所在班级",
//                    type = EditType.CHOICE,
//                    choiceType = @ChoiceType(
//                            fetchHandler = SqlChoiceFetchHandler.class,
//                            fetchHandlerParams = {"selcet id, name from e_upms_menu"}
//                    )
//            )
//    )
//    private String student_class;
/*
 * 仅需将 fetchHandler 定义为 SqlChoiceFetchHandler 即可
 * fetchHandlerParams 参数值为 SQL 语句
 */
    @EruptField(
            views = @View(title = "所在班级"),
            edit = @Edit(
                    search = @Search,
                    title = "所在班级",
                    type = EditType.CHOICE,
                    choiceType = @ChoiceType(
                            fetchHandler = SqlChoiceFetchHandler.class,
                            //参数一必填，表示sql语句
                            //参数二可不填，表示缓存时间，默认为3000毫秒，1.6.10及以上版本支持
                            fetchHandlerParams = {"select id, course_id from course", "5000"}
                    ))
    )
    private String student_class;

    @EruptField(
            views = @View(
                    title = "签到情况"
            ),
            edit = @Edit(
                    title = "签到情况",
                    type = EditType.CHOICE, search = @Search,
                    choiceType = @ChoiceType(vl = {@VL(value = "已签到", label = "已签到"), @VL(value = "未签到", label = "未签到")})
            )
    )
    private String student_come;

    @EruptField(
            views = @View(
                    title = "缴费情况"
            ),
            edit = @Edit(
                    title = "缴费情况",
                    type = EditType.CHOICE, search = @Search,
                    choiceType = @ChoiceType(vl = {@VL(value = "已缴费", label = "已缴费"), @VL(value = "未缴费", label = "未缴费")})
            )
    )
    private String student_pay;
}