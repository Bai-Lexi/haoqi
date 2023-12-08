package com.example.demo.Enity;

/*
 * Copyright © 2020-2035 erupt.xyz All rights reserved.
 * Author: YuePeng (erupts@126.com)
 */

/*
 * Copyright © 2020-2035 erupt.xyz All rights reserved.
 * Author: YuePeng (erupts@126.com)
 */

/*
 * Copyright © 2020-2035 erupt.xyz All rights reserved.
 * Author: YuePeng (erupts@126.com)
 */

import javax.persistence.*;

import com.example.demo.DataProxy.RegistDataProxy;
import xyz.erupt.annotation.*;
import xyz.erupt.annotation.sub_erupt.*;
import xyz.erupt.annotation.sub_field.*;
import xyz.erupt.annotation.sub_field.sub_edit.*;
import xyz.erupt.upms.model.base.HyperModel;
import xyz.erupt.jpa.model.BaseModel;
import java.util.Set;
import java.util.Date;

@Erupt(name = "Registration",dataProxy = RegistDataProxy.class)
@Table(name = "registration")
@Entity
public class Registration extends BaseModel {

    @EruptField(
            views = @View(
                    title = "姓名"
            ),
            edit = @Edit(
                    title = "姓名",
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
    private String phone;

    public String getSname() {
        return sname;
    }

    public Set<Course> getRcourse() {
        return Rcourse;
    }

    @EruptField(
            views = @View(
                    title = "邮箱"
            ),
            edit = @Edit(
                    title = "邮箱",
                    type = EditType.INPUT, search = @Search,
                    inputType = @InputType
            )
    )
    private String email;

    @EruptField(
            views = @View(
                    title = "课程"
            ),
            edit = @Edit(
                    title = "课程",
                    type = EditType.TAB_TABLE_REFER, search = @Search, notNull = true
            )
    )
    @ManyToMany
    @JoinTable(name = "registration_course",
            joinColumns = @JoinColumn(name = "registration_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
    private Set<Course> Rcourse;

}