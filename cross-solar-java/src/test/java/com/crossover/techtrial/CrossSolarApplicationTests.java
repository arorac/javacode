package com.crossover.techtrial;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.crossover.techtrial.dto.DailyElectricity;
import com.crossover.techtrial.service.HourlyElectricityService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrossSolarApplicationTests {

	@Autowired
	private HourlyElectricityService hourlyElectricityService;

	@Test
	public void contextLoads() {
		List<DailyElectricity> dailyElectricityStatisticsReports=hourlyElectricityService.findDailyElectricityStatisticsReports();
	
		for(DailyElectricity dailyElectricity:dailyElectricityStatisticsReports) {
			System.out.println(dailyElectricity);
		}
		
	}
}
