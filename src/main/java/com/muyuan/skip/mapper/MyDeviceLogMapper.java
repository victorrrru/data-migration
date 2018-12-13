package com.muyuan.skip.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.muyuan.skip.entity.MyDeviceLog;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Repository;

/**
 * 日志表
 * 
 * @author fanwenwu
 * @email 
 * @date 2018-11-23 15:43:53
 */
@Repository
public interface MyDeviceLogMapper extends BaseMapper<MyDeviceLog> {

    @Delete("delete from my_device_log where receive_time < #{date}")
    int deleteByDate(String date);
}
