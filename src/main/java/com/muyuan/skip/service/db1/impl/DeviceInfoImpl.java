package com.muyuan.skip.service.db1.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.muyuan.skip.entity.MyDeviceInfo;
import com.muyuan.skip.mapper.MyDeviceInfoMapper;
import com.muyuan.skip.service.db1.DeviceInfoBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 范文武
 * @date 2018/12/07 16:13
 */
@Service
public class DeviceInfoImpl extends ServiceImpl<MyDeviceInfoMapper, MyDeviceInfo> implements DeviceInfoBiz {

    @Autowired
    private MyDeviceInfoMapper mapper;

    @Override
    public Boolean insetAll(List<MyDeviceInfo> infos) {
        return insertBatch(infos);
    }

    @Override
    public Integer getByDeviceNo(String deviceNo) {
        return mapper.getId(deviceNo);
    }
}
