package com.muyuan.skip.service.db1.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.muyuan.skip.entity.MyArea;
import com.muyuan.skip.mapper.MyAreaMapper;
import com.muyuan.skip.service.db1.DeviceAreaBiz;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 范文武
 * @date 2018/12/07 16:13
 */
@Service
public class DeviceAreaImpl extends ServiceImpl<MyAreaMapper, MyArea> implements DeviceAreaBiz {

    @Override
    public Boolean insetAll(List<MyArea> areas) {
        return insertBatch(areas);
    }
}
