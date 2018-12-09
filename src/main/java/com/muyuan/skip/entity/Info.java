package com.muyuan.skip.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * @author 范文武
 * @date 2018/10/23 10:10
 */
@TableName("INFO")
@Data
@Accessors(chain = true)
public class Info {
    @TableField(value = "设备编号")
    private String deviceNo;
    @TableField(value = "车号")
    private String vehicleNo;
    @TableField(value = "分公司")
    private String company;
    @TableField(value = "MAC")
    private String mac;
    @TableField(value = "在线")
    private Byte isOnline;
    @TableField(value = "地址")
    private String address;
    @TableField(value = "当前IP")
    private String ip;
    @TableField(value = "Lock")
    private Byte fortification;
    @TableField(value = "信号")
    private Integer semaphore;
    @TableField(value = "注册时间")
    private String registTime;
    @TableField(value = "方向")
    private Integer direction;
    @TableField(value = "通信时间")
    private String communicationTime;
    @TableField(value = "SIM")
    private String sim;
    @TableField(value = "报警")
    private String alarm;
    @TableField(value = "硬件版本")
    private String hardware;
    @TableField(value = "软件版本")
    private String software;
    @TableField(value = "GPS")
    private Byte gps;
    @TableField(value = "x1")
    private BigInteger lon;
    @TableField(value = "y1")
    private BigInteger lat;
    @TableField(value = "posX")
    private BigInteger posX;
    @TableField(value = "posY")
    private BigInteger postY;
    @TableField(value = "note")
    private String note;
    @TableField(value = "lock1")
    private Byte isLock;
}
