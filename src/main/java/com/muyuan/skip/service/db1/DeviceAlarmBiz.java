package com.muyuan.skip.service.db1;

import com.baomidou.mybatisplus.service.IService;
import com.muyuan.skip.entity.MyDeviceAlarm;
import com.muyuan.skip.entity.MyDeviceLog;

import java.util.List;

/**
 * @author 范文武
 * @date 2018/12/07 16:13
 */
public interface DeviceAlarmBiz extends IService<MyDeviceAlarm> {
    Boolean insetAll(List<MyDeviceAlarm> logs);
}
