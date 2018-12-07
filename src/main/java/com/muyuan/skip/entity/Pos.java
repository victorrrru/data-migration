package com.muyuan.skip.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 范文武
 * @date 2018/11/07 09:15
 */
@TableName("POS1")
@Data
@Accessors(chain = true)
public class Pos {
    @TableField(value = "设备编号")
    private String deviceNo;
    @TableField(value = "GPS")
    private Byte gps;
    @TableField(value = "x1")
    private Long x1;
    @TableField(value = "y1")
    private Long y1;
    @TableField(value = "time")
    private String time;
    @TableField(value = "dre")
    private Byte direction;
    @TableField(value = "speed")
    private Integer speed;
}
