package com.muyuan.skip.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 设备信息
 *
 * @author fanwenwu
 * @email
 * @date 2018-11-23 15:43:52
 */
@TableName("my_device_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyDeviceInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    // 主键
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    // 设备编号
    @TableField(value = "device_no")
    private String deviceNo;

    // 车辆编号
    @TableField(value = "vehicle_no")
    private String vehicleNo;

    // 区域主键
    @TableField(value = "area_id")
    private Integer areaId;

    // 分公司
    @TableField(value = "company")
    private String company;

    // 地址
    @TableField(value = "address")
    private String address;

    // 是否在线(0离线，1在线)
    @TableField(value = "is_online")
    private Byte isOnline;

    // 解锁状态（0解锁，1上锁）
    @TableField(value = "is_lock")
    private Byte isLock;

    // 启用设防（0禁用， 1启用）
    @TableField(value = "fortification")
    private Byte fortification;

    // 信号
    @TableField(value = "semaphore")
    private Integer semaphore;

    // 注册时间
    @TableField(value = "regist_time")
    private String registTime;

    // 通信时间
    @TableField(value = "communication_time")
    private String communicationTime;

    // 发料提示
    @TableField(value = "note")
    private String note;

    // 经度
    @TableField(value = "lon")
    private BigDecimal lon;

    // 纬度
    @TableField(value = "lat")
    private BigDecimal lat;

    // 报警
    @TableField(value = "alarm")
    private String alarm;

    // mac
    @TableField(value = "mac")
    private String mac;

    // ip
    @TableField(value = "ip")
    private String ip;

    // port
    @TableField(value = "port")
    private Integer port;

    // 方向
    @TableField(value = "direction")
    private Integer direction;

    // SIM
    @TableField(value = "sim")
    private String sim;

    // 硬件版本
    @TableField(value = "hardware")
    private String hardware;

    // 软件版本
    @TableField(value = "software")
    private String software;

    //
    @TableField(value = "crt_time")
    private Date crtTime;

    //
    @TableField(value = "crt_user")
    private String crtUser;

    //
    @TableField(value = "crt_name")
    private String crtName;

    //
    @TableField(value = "crt_hsot")
    private String crtHost;

    //
    @TableField(value = "upd_time")
    private Date updTime;

    //
    @TableField(value = "upd_user")
    private String updUser;

    //
    @TableField(value = "upd_name")
    private String updName;

    //
    @TableField(value = "upd_host")
    private String updHost;
}
