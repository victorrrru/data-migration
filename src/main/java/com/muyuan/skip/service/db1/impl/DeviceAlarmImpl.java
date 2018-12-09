package com.muyuan.skip.service.db1.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.muyuan.skip.entity.MyDeviceAlarm;
import com.muyuan.skip.entity.MyDeviceLog;
import com.muyuan.skip.mapper.MyDeviceAlarmMapper;
import com.muyuan.skip.mapper.MyDeviceLogMapper;
import com.muyuan.skip.service.db1.DeviceAlarmBiz;
import com.muyuan.skip.service.db1.DeviceLogBiz;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 范文武
 * @date 2018/12/07 16:13
 */
@Service
public class DeviceAlarmImpl extends ServiceImpl<MyDeviceAlarmMapper, MyDeviceAlarm> implements DeviceAlarmBiz {

    @Override
    public Boolean insetAll(List<MyDeviceAlarm> logs) {
        return insertBatch(logs, 1000);
    }
}
