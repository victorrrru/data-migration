package com.muyuan.skip.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.muyuan.skip.entity.Info;
import com.muyuan.skip.entity.MyDeviceInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 范文武
 * @date 2018/10/23 10:19
 */
@Repository
public interface InfoMapper extends BaseMapper<Info> {
    @Select("SELECT 设备编号 AS deviceNo,车号 AS vehicleNo,分公司 AS company,MAC AS mac,在线 AS isOnline,地址 AS address,当前IP AS ip,\n" +
            "\t\tLock AS fortification,信号 AS semaphore,注册时间 AS registTime,方向 AS direction,通信时间 AS communicationTime,\n" +
            "\t\tSIM AS sim,报警 AS alarm,硬件版本 AS hardware,软件版本 AS software,GPS AS gps,x1 AS lon,y1 AS lat,\n" +
            "\t\tposX,posY,note,lock1 AS isLock\n" +
            "FROM INFO")
    List<Info> listInfo();
}
