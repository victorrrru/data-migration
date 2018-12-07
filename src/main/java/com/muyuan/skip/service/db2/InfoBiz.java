package com.muyuan.skip.service.db2;

import com.baomidou.mybatisplus.service.IService;
import com.muyuan.skip.entity.Info;
import com.muyuan.skip.entity.MyDeviceInfo;

import java.util.List;

/**
 * @author 范文武
 * @date 2018/12/07 15:08
 */
public interface InfoBiz extends IService<Info> {
    List<Info> listInfo();
}
