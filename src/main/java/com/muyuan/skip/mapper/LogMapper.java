package com.muyuan.skip.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.muyuan.skip.entity.Log;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 日志
 *
 * @date 2018-10-23 09:27:29
 */
@Repository
public interface LogMapper extends BaseMapper<Log> {
    @Select("SELECT ID AS id,设备编号 AS deviceNo,警情 AS alarm,接收时间 AS receiveTime,no,GPS AS gps,x1 as lon,y1 as lat,speed,alarm as logType FROM LOG WHERE ID=#{id}")
    Log getById(Integer id);
    @Select("SELECT 设备编号 AS deviceNo,警情 AS alarm,接收时间 AS receiveTime,GPS AS gps,x1 as lon,y1 as lat,speed,alarm as logType\n" +
            "FROM dbo.LOG\n" +
            "WHERE 接收时间 between #{begin} and #{end}")
    List<Log> getLog(@Param("begin") String begin, @Param("end") String end);
    @Select("SELECT 设备编号 AS deviceNo,警情 AS alarm,接收时间 AS receiveTime,GPS AS gps,x1 as lon,y1 as lat,speed,alarm as logType\n" +
            "FROM dbo.LOG\n" +
            "WHERE 接收时间 between #{begin} and #{end}\n" +
            "and alarm in (8,16,17,20,32)")
    List<Log> getAlarm(@Param("begin") String begin, @Param("end") String end);
}
