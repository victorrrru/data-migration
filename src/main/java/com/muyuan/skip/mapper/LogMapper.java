package com.muyuan.skip.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.muyuan.skip.entity.Log;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 日志
 *
 * @author 姬响
 * @date 2018-10-23 09:27:29
 */
public interface LogMapper extends BaseMapper<Log> {
    @Select("SELECT ID AS id,设备编号 AS equipmentNo,警情 AS alert,时间 AS time,接收时间 AS receiveTime,no,GPS AS gps,x1,y1,speed,dre,alarm,车辆 AS vehicle FROM LOG WHERE ID=#{id}")
    Log getById(Integer id);
}
