package com.muyuan.skip.service.db1;

import com.baomidou.mybatisplus.service.IService;
import com.muyuan.skip.entity.MyDeviceLog;

import java.util.List;

/**
 * @author 范文武
 * @date 2018/12/07 16:13
 */
public interface DeviceLogBiz extends IService<MyDeviceLog> {
    Boolean insetAll(List<MyDeviceLog> logs);
}
