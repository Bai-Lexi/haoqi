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

@Erupt(name = "Investigation", power = @Power(importable = true, export = true))
@Table(name = "Investigation")
@Entity
public class Investigation extends BaseModel {

    @EruptField(
            views = @View(
                    title = "课程号"
            ),
            edit = @Edit(
                    search = @Search,
                    title = "课程号",
                    type = EditType.CHOICE, notNull = true,
                    choiceType = @ChoiceType(
                            fetchHandler = SqlChoiceFetchHandler.class,
                            //参数一必填，表示sql语句
                            //参数二可不填，表示缓存时间，默认为3000毫秒，1.6.10及以上版本支持
                            fetchHandlerParams = {"select id, course_id from course", "5000"}
                    )
            )
    )
    private String course_id;

    @EruptField(
            views = @View(
                    title = "课程评分"
            ),
            edit = @Edit(
                    title = "课程评分",
                    type = EditType.RATE,search = @Search,
                    rateType = @RateType(allowHalf = true, count = 10)
            )
    )
    private Float rate;


    @EruptField(
            views = @View(
                    title = "课程评价、建议"
            ),
            edit = @Edit(
                    title = "课程评价、建议",
                    type = EditType.TEXTAREA, notNull = true
            )
    )
    private @Lob String course_evaluate;


//    @EruptField(
//            edit = @Edit(
//                    title = "空",
//                    type = EditType.EMPTY
//            )
//    )
//    private String input;
//    @EruptField(
//            edit = @Edit(
//                    title = "空",
//                    type = EditType.EMPTY
//            )
//    )
//    private String input2;

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
    private String course_teacher1;

    @EruptField(
            views = @View(
                    title = "教师评分"
            ),
            edit = @Edit(
                    title = "教师评分",
                    type = EditType.RATE, search = @Search, notNull = true,
                    rateType = @RateType(allowHalf = true, count = 10)
            )
    )
    private Integer score;

    @EruptField(
            views = @View(
                    title = "教师评价、建议"
            ),
            edit = @Edit(
                    title = "教师评价、建议",
                    type = EditType.TEXTAREA,  notNull = true
            )
    )
    private @Lob String course_teacher_evaluate1;


//    @EruptField(
//            views = @View(
//                    title = "教师2"
//            ),
//            edit = @Edit(
//                    search = @Search,
//                    title = "教师2",
//                    type = EditType.CHOICE,
//                    choiceType = @ChoiceType(
//                            fetchHandler = SqlChoiceFetchHandler.class,
//                            //参数一必填，表示sql语句
//                            //参数二可不填，表示缓存时间，默认为3000毫秒，1.6.10及以上版本支持
//                            fetchHandlerParams = {"select id, tname from teacher_info", "5000"}
//                    )
//            )
//    )
//    private String course_teacher2;
//
//    @EruptField(
//            views = @View(
//                    title = "教师评价2"
//            ),
//            edit = @Edit(
//                    title = "教师评价2",
//                    type = EditType.TEXTAREA
//            )
//    )
//    private @Lob String course_teacher_evaluate2;
//
//    @EruptField(
//            views = @View(
//                    title = "教师3"
//            ),
//            edit = @Edit(
//                    search = @Search,
//                    title = "教师3",
//                    type = EditType.CHOICE,
//                    choiceType = @ChoiceType(
//                            fetchHandler = SqlChoiceFetchHandler.class,
//                            //参数一必填，表示sql语句
//                            //参数二可不填，表示缓存时间，默认为3000毫秒，1.6.10及以上版本支持
//                            fetchHandlerParams = {"select id, tname from teacher_info", "5000"}
//                    )
//            )
//    )
//    private String course_teacher3;
//
//    @EruptField(
//            views = @View(
//                    title = "教师评价3"
//            ),
//            edit = @Edit(
//                    title = "教师评价3",
//                    type = EditType.TEXTAREA
//            )
//    )
//    private @Lob String course_teacher_evaluate3;




}