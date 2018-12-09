package com.muyuan.skip.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.muyuan.skip.entity.MyDeviceInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 设备信息
 * 
 * @author fanwenwu
 * @email 
 * @date 2018-11-23 15:43:52
 */
@Repository
public interface MyDeviceInfoMapper extends BaseMapper<MyDeviceInfo> {
    @Select("SELECT id, ip, device_no AS deviceNo, communication_time AS communicationTime FROM my_device_info where is_online = 1")
    List<MyDeviceInfo> listDevice();
    @Select("select id from my_device_info where device_no=#{deviceNo}")
    Integer getId(String deviceNo);
}
