package com.muyuan.skip.service.db2;

import com.baomidou.mybatisplus.service.IService;
import com.muyuan.skip.entity.Log;

import java.util.List;

/**
 * @author 范文武
 * @date 2018/12/07 15:08
 */
public interface LogBiz extends IService<Log> {
    Log getLogById(Integer id);
    List<Log> listLog(String begin, String end);

    List<Log> listAlarm(String begin, String end);
}
