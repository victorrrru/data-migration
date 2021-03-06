package com.muyuan.skip.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * 日志
 *
 * @email
 * @date 2018-10-23 09:31:41
 */
@TableName("LOG")
@Data
@Accessors(chain = true)
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "设备编号")
    private String deviceNo;

    @TableField(value = "警情")
    private String alarm;

    @TableField(value = "接收时间")
    private String receiveTime;

    @TableField(value = "GPS")
    private Integer gps;

    @TableField(value = "x1")
    private BigInteger lon;

    @TableField(value = "y1")
    private BigInteger lat;

    @TableField(value = "speed")
    private Integer speed;

    @TableField(value = "alarm")
    private Integer logType;

}
