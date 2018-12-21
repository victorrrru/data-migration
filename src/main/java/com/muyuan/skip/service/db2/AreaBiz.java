package com.muyuan.skip.service.db2;

import com.baomidou.mybatisplus.service.IService;
import com.muyuan.skip.entity.Area;

import java.util.List;

/**
 * @author 范文武
 * @date 2018/12/07 15:08
 */
public interface AreaBiz extends IService<Area> {
    List<Area> selectAll();
}
