package com.muyuan.skip.service.db2.impl;

import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.muyuan.skip.entity.Log;
import com.muyuan.skip.mapper.LogMapper;
import com.muyuan.skip.service.db2.LogBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 范文武
 * @date 2018/12/07 11:52
 */
@Service
public class LogBizImpl extends ServiceImpl<LogMapper, Log> implements LogBiz {
    @Autowired
    private LogMapper logMapper;

    @Override
    public Log getLogById(Integer id) {
        return logMapper.getById(id);
    }
}
