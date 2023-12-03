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

@Erupt(name = "TeacherInfo")
@Table(name = "TeacherInfo")
@Entity
public class TeacherInfo extends BaseModel {

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
                    title = "职称"
            ),
            edit = @Edit(
                    title = "职称",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String title;

    @EruptField(
            views = @View(
                    title = "擅长领域"
            ),
            edit = @Edit(
                    title = "擅长领域",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String domain;

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
    private String temail;

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
    private String tphone;

}