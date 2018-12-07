package com.muyuan.skip.service.db2.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.muyuan.skip.entity.Info;
import com.muyuan.skip.entity.MyDeviceInfo;
import com.muyuan.skip.mapper.InfoMapper;
import com.muyuan.skip.service.db2.InfoBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author 范文武
 * @date 2018/12/07 11:52
 */
@Service
public class InfoBizImpl extends ServiceImpl<InfoMapper, Info> implements InfoBiz {
    @Autowired
    private InfoMapper infoMapper;

    @Override
    public List<Info> listInfo() {
        return infoMapper.listInfo();
    }

}
