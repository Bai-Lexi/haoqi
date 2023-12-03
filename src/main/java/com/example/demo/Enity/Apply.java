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

@Erupt(name = "Apply")
@Table(name = "Apply")
@Entity
public class Apply extends BaseModel {

    @EruptField(
            views = @View(
                    title = "申请序号"
            ),
            edit = @Edit(
                    title = "申请序号",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String apply_order;

    @EruptField(
            views = @View(
                    title = "公司名称"
            ),
            edit = @Edit(
                    title = "公司名称",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String cname;

    @EruptField(
            views = @View(
                    title = "申请时间"
            ),
            edit = @Edit(
                    title = "申请时间",
                    type = EditType.DATE, search = @Search, notNull = true,
                    dateType = @DateType
            )
    )
    private String apply_time;

    @EruptField(
            views = @View(
                    title = "是否接收申请"
            ),
            edit = @Edit(
                    title = "是否接收申请",
                    type = EditType.CHOICE, search = @Search,
                    choiceType = @ChoiceType(vl = {@VL(value = "是", label = "是"), @VL(value = "否", label = "否")})
            )
    )
    private String apply_choice;

}
