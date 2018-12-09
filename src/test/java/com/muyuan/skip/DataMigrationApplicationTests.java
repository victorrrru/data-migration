package com.muyuan.skip;

import com.muyuan.skip.config.BeanMapperUtil;
import com.muyuan.skip.entity.*;
import com.muyuan.skip.service.db1.DeviceAlarmBiz;
import com.muyuan.skip.service.db1.DeviceInfoBiz;
import com.muyuan.skip.service.db1.DeviceLogBiz;
import com.muyuan.skip.service.db2.InfoBiz;
import com.muyuan.skip.service.db2.LogBiz;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataMigrationApplicationTests {

	@Autowired
	private LogBiz logBiz;
	@Autowired
	private InfoBiz infoBiz;
	@Autowired
	private DeviceInfoBiz deviceInfoBiz;
	@Autowired
	private DeviceLogBiz deviceLogBiz;
	@Autowired
	private DeviceAlarmBiz deviceAlarmBiz;

	@Test
	public void contextLoads() {
		Log log = logBiz.getLogById(9890185);
		System.out.println(log.toString());
	}

	@Test
	public void testInfo() {
		List<Info> infos = infoBiz.listInfo();
		List<MyDeviceInfo> list = new LinkedList<>();
		for(Info info : infos) {
			MyDeviceInfo entity = BeanMapperUtil.map(info, MyDeviceInfo.class);
			entity.setLon(new BigDecimal(info.getLon() != null ? info.getLon() : new BigInteger(String.valueOf(0))).divide(BigDecimal.valueOf(1000000), 6, BigDecimal.ROUND_CEILING));
			entity.setLat(new BigDecimal(info.getLat() != null ? info.getLat() : new BigInteger(String.valueOf(0))).divide(BigDecimal.valueOf(1000000), 6, BigDecimal.ROUND_CEILING));
			list.add(entity);
		}
		deviceInfoBiz.insetAll(list);
	}

	/**
	 * log  11-07   ----   12-06
	 * @author fww
	 */
	@Test
	public void testLog() {
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime begin = LocalDateTime.of(2018, 11, 7, 0, 0, 0);
		LocalDateTime end = begin.plusDays(5);
		List<Log> logs = logBiz.listLog(pattern.format(begin), pattern.format(end));
		List<MyDeviceLog> list = new LinkedList<>();
		int i = 0;
		for(Log log : logs) {
			System.out.println(++i);
			MyDeviceLog entity = BeanMapperUtil.map(log, MyDeviceLog.class);
			Integer id = deviceInfoBiz.getByDeviceNo(log.getDeviceNo());
			entity.setDeviceId(id);
			entity.setLon(new BigDecimal(log.getLon() != null ? log.getLon() : new BigInteger(String.valueOf(0))).divide(BigDecimal.valueOf(1000000), 6, BigDecimal.ROUND_CEILING));
			entity.setLat(new BigDecimal(log.getLat() != null ? log.getLat() : new BigInteger(String.valueOf(0))).divide(BigDecimal.valueOf(1000000), 6, BigDecimal.ROUND_CEILING));
			entity.setSpeed(new BigDecimal(log.getSpeed() != null ? log.getSpeed() : 0).divide(BigDecimal.valueOf(10), 1, BigDecimal.ROUND_CEILING));
			list.add(entity);
		}
		deviceLogBiz.insetAll(list);
	}

	/**
	 * alarm  11-07   ----   12-06
	 * //这里加事物会引起无法切库
	 * @author fww
	 */
	@Test
	public void testAlarm() {
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime begin = LocalDateTime.of(2018, 11, 7, 0, 0, 0);
		LocalDateTime end = begin.plusDays(30);
		List<Log> logs = logBiz.listAlarm(pattern.format(begin), pattern.format(end));
		List<MyDeviceAlarm> list = new LinkedList<>();
		int i = 0;
		for(Log log : logs) {
			MyDeviceAlarm entity = BeanMapperUtil.map(log, MyDeviceAlarm.class);
			System.out.println(++i);
			Integer id = deviceInfoBiz.getByDeviceNo(log.getDeviceNo());
			entity.setDeviceId(id);
			entity.setLon(new BigDecimal(log.getLon() != null ? log.getLon() : new BigInteger(String.valueOf(0))).divide(BigDecimal.valueOf(1000000), 6, BigDecimal.ROUND_CEILING));
			entity.setLat(new BigDecimal(log.getLat() != null ? log.getLat() : new BigInteger(String.valueOf(0))).divide(BigDecimal.valueOf(1000000), 6, BigDecimal.ROUND_CEILING));
			entity.setSpeed(new BigDecimal(log.getSpeed() != null ? log.getSpeed() : 0).divide(BigDecimal.valueOf(10), 1, BigDecimal.ROUND_CEILING));
			list.add(entity);
		}
		deviceAlarmBiz.insetAll(list);
	}

}
