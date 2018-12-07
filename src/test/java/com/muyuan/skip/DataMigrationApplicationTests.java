package com.muyuan.skip;

import com.muyuan.skip.entity.Info;
import com.muyuan.skip.entity.Log;
import com.muyuan.skip.entity.MyDeviceInfo;
import com.muyuan.skip.service.db1.DeviceInfoBiz;
import com.muyuan.skip.service.db2.InfoBiz;
import com.muyuan.skip.service.db2.LogBiz;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

	@Test
	public void contextLoads() {
		Log log = logBiz.getLogById(9890185);
		System.out.println(log.toString());
	}

	@Test
	public void test1() {
		List<Info> infos = infoBiz.listInfo();
		for(Info info : infos) {
		}
		System.out.println(infos.toString());
	}

}
