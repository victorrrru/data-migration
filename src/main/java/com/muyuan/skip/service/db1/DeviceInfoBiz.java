package com.muyuan.skip.service.db1;

import com.baomidou.mybatisplus.service.IService;
import com.muyuan.skip.entity.MyDeviceInfo;

import java.util.List;

/**
 * @author 范文武
 * @date 2018/12/07 16:13
 */
public interface DeviceInfoBiz extends IService<MyDeviceInfo> {
    Boolean insetAll(List<MyDeviceInfo> infos);
}
