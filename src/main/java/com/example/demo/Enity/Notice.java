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

@Erupt(name = "Notice")
@Table(name = "Notice")
@Entity
public class Notice extends BaseModel {

    @EruptField(
            views = @View(
                    title = "通知序号"
            ),
            edit = @Edit(
                    title = "通知序号",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String notice_id;

    @EruptField(
            views = @View(
                    title = "通知内容"
            ),
            edit = @Edit(
                    title = "通知内容",
                    type = EditType.TEXTAREA, search = @Search, notNull = true
            )
    )
    private @Lob String notice_content;

}
