package com.muyuan.skip.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.muyuan.skip.entity.Area;
import com.muyuan.skip.entity.Log;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 日志
 *
 * @date 2018-10-23 09:27:29
 */
@Repository
public interface AreaMapper extends BaseMapper<Area> {
    @Select("select * from dbo.area")
    List<Area> selectArea();
}
