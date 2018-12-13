package com.muyuan.skip.quartz;

import com.muyuan.skip.config.BeanMapperUtil;
import com.muyuan.skip.entity.*;
import com.muyuan.skip.service.db1.DeviceAlarmBiz;
import com.muyuan.skip.service.db1.DeviceInfoBiz;
import com.muyuan.skip.service.db1.DeviceLogBiz;
import com.muyuan.skip.service.db2.InfoBiz;
import com.muyuan.skip.service.db2.LogBiz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 范文武
 * @date 2018/12/11 11:50
 */
@Component
@Slf4j
public class DataSync {

    @Autowired
    private LogBiz logBiz;
    @Autowired
    private InfoBiz infoBiz;
    @Autowired
    private DeviceInfoBiz deviceInfoBiz;
    @Autowired
    private DeviceAlarmBiz deviceAlarmBiz;
    @Autowired
    private DeviceLogBiz deviceLogBiz;
    private DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    @Scheduled(cron = "0 0 0 * * *")
    public void infoQuartz() {
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDate end = LocalDate.of(dateTime.getYear(), dateTime.getMonth(), dateTime.getDayOfMonth());
        LocalDate begin = end.minusDays(1);
        log.info(begin + ", 设备同步开始");
        List<Info> infos = infoBiz.listInfo();
        int addNum = 0;
        for(Info info : infos) {
            MyDeviceInfo entity = BeanMapperUtil.map(info, MyDeviceInfo.class);
            entity.setCompany(info.getCompany() != null ? info.getCompany().trim() : "");
            entity.setAddress(info.getAddress() != null ? info.getAddress().trim() : "");
            entity.setVehicleNo(info.getVehicleNo() != null ? info.getVehicleNo().trim() : "");
            entity.setMac(info.getMac() != null ? info.getMac().trim() : "");
            entity.setIp(info.getIp() != null ? info.getIp().trim() : "");
            entity.setHardware(info.getHardware() != null ? info.getHardware().trim() : "");
            entity.setSoftware(info.getSoftware() != null ? info.getSoftware().trim() : "");
            entity.setNote(info.getNote() != null ? info.getNote().trim() : "");
            entity.setLon(new BigDecimal(info.getLon() != null ? info.getLon() : new BigInteger(String.valueOf(0))).divide(BigDecimal.valueOf(1000000), 6, BigDecimal.ROUND_CEILING));
            entity.setLat(new BigDecimal(info.getLat() != null ? info.getLat() : new BigInteger(String.valueOf(0))).divide(BigDecimal.valueOf(1000000), 6, BigDecimal.ROUND_CEILING));
            Integer id = deviceInfoBiz.getByDeviceNo(info.getDeviceNo());
            if (id == null) {
                deviceInfoBiz.insert(entity);
                addNum++;
            }
        }
        log.info(begin + ", 设备同步,新增" + addNum);
    }

    @Scheduled(cron = "0 10 0 * * *")
    public void larmQuartz() {
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDate end = LocalDate.of(dateTime.getYear(), dateTime.getMonth(), dateTime.getDayOfMonth());
        LocalDate begin = end.minusDays(1);
        log.info(begin + ", 警情同步开始");
        List<Log> logs = logBiz.listAlarm(pattern.format(begin), pattern.format(end));
        List<MyDeviceAlarm> list = new LinkedList<>();
        int i = 0;
        for(Log log : logs) {
            MyDeviceAlarm entity = BeanMapperUtil.map(log, MyDeviceAlarm.class);
            Integer id = deviceInfoBiz.getByDeviceNo(log.getDeviceNo());
            entity.setDeviceId(id);
            entity.setAlarm(log.getAlarm().trim());
            entity.setLon(new BigDecimal(log.getLon() != null ? log.getLon() : new BigInteger(String.valueOf(0))).divide(BigDecimal.valueOf(1000000), 6, BigDecimal.ROUND_CEILING));
            entity.setLat(new BigDecimal(log.getLat() != null ? log.getLat() : new BigInteger(String.valueOf(0))).divide(BigDecimal.valueOf(1000000), 6, BigDecimal.ROUND_CEILING));
            entity.setSpeed(new BigDecimal(log.getSpeed() != null ? log.getSpeed() : 0).divide(BigDecimal.valueOf(10), 1, BigDecimal.ROUND_CEILING));
            list.add(entity);
        }
        deviceAlarmBiz.insetAll(list);
        log.info(begin + ", 警情同步，新增" + logs.size() + "条");
    }

    @Scheduled(cron = "0 0 4 * * FRI")
    public void deleteLogQuartz() {
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDate end = LocalDate.of(dateTime.getYear(), dateTime.getMonth(), dateTime.getDayOfMonth());
        LocalDate begin = end.minusDays(1);
        log.info(begin + ", 删除日志开始");
        begin = begin.minusDays(7);
        int count = deviceLogBiz.deleteByDate(pattern.format(begin));
        log.info(begin + ", 日志删除，删除" + count + "条");
    }

}
