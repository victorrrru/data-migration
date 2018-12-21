package com.muyuan.skip.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;


/**
 * 站点区域表
 *
 * @author fanwenwu
 * @email
 * @date 2018-11-23 15:43:53
 */
@TableName("my_area")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MyArea implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    //设备主键

    @TableField(value = "device_id")
    private Integer deviceId;

    //设备编号

    @TableField(value = "device_no")
    private String deviceNo;

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

    @TableField(value = "pots_hex")
    private String potsHex;

    @TableField(value = "time")
    private Date time;


}
