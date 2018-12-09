package com.muyuan.skip.service.db2.impl;

import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.muyuan.skip.entity.Log;
import com.muyuan.skip.mapper.LogMapper;
import com.muyuan.skip.service.db2.LogBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Log> listLog(String begin, String end) {
        return logMapper.getLog(begin, end);
    }

    @Override
    public List<Log> listAlarm(String begin, String end) {
        return logMapper.getAlarm(begin, end);
    }
}
