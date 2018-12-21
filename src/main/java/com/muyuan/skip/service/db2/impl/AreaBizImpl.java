package com.muyuan.skip.service.db2.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.muyuan.skip.entity.Area;
import com.muyuan.skip.entity.Log;
import com.muyuan.skip.mapper.AreaMapper;
import com.muyuan.skip.mapper.LogMapper;
import com.muyuan.skip.service.db2.AreaBiz;
import com.muyuan.skip.service.db2.LogBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 范文武
 * @date 2018/12/07 11:52
 */
@Service
public class AreaBizImpl extends ServiceImpl<AreaMapper, Area> implements AreaBiz {

    @Autowired
    private AreaMapper mapper;

    @Override
    public List<Area> selectAll() {
        return mapper.selectArea();
    }
}
