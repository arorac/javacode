package com.crossover.techtrial.repository;

import com.crossover.techtrial.dto.DailyElectricity;
import com.crossover.techtrial.model.HourlyElectricity;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * HourlyElectricity Repository is for all operations for HourlyElectricity.
 * @author Crossover
 */
@RestResource(exported = false)
public interface HourlyElectricityRepository 
    extends PagingAndSortingRepository<HourlyElectricity,Long> {
  Page<HourlyElectricity> findAllByPanelIdOrderByReadingAtDesc(Long panelId,Pageable pageable);
  
  @Query("select "
			+ " new com.crossover.techtrial.dto.DailyElectricity(CAST(he.readingAt as LocalDate),SUM(he.generatedElectricity),AVG(he.generatedElectricity),MIN(he.generatedElectricity),MAX(he.generatedElectricity)) "
			+ " FROM HourlyElectricity he WHERE CAST(he.readingAt as LocalDate)<CURRENT_DATE " + " GROUP BY CAST(he.readingAt as LocalDate) ")
	List<DailyElectricity> findDailyElectricityStatisticsReports();
}
