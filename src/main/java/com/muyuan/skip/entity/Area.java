package com.muyuan.skip.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 区域
 *
 * @author 姬响
 * @email
 * @date 2018-10-23 09:31:41
 */
@TableName("AREA")
@Data
@Accessors(chain = true)
public class Area implements Serializable {
    private static final long serialVersionUID = 1L;
    //主键
    @TableId(value = "ID", type = IdType.AUTO)
    private String id;

    //版本信息

    @TableField(value = "ver")
    private Byte ver;
    //坐标点数
    @TableField(value = "num")
    private Byte num;
    @TableField(value = "flag")
    private Byte flag;

    //坐标信息存储格式  xx,yy;aa,bb;

    @TableField(value = "pots")
    private String pots;

    @TableField(value = "time")
    private Date time;


}
