package com.call.callcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.call.callcenter.entity.CallCenter;

@Repository
public interface CallCenterRepository extends JpaRepository<CallCenter, Long>{
	
	@Query(value = "select CONCAT_WS ('-', concat_ws(' ',starthr,stime), concat_ws(' ',endhr,etime)) result "
			+ "from (select extract(hour from start_time) as starthr,DATE_FORMAT(start_time,'%p') as stime, "
			+ "		extract(hour from end_time) as endhr,DATE_FORMAT(end_time,'%p')  as etime, "
			+ "        count(*) as cnt "
			+ "      from callcenter "
			+ "      group by extract(hour from start_time),DATE_FORMAT(start_time,'%p'),extract(hour from end_time),DATE_FORMAT(end_time,'%p') "
			+ "     ) t "
			+ "order by cnt desc "
			+ "limit 1")
	public String findCallValumeHighestHours();

	@Query(value = "select CONCAT_WS ('-', concat_ws(' ',starthr,stime), concat_ws(' ',endhr,etime)) result "
			+ "from (select extract(hour from start_time) as starthr,DATE_FORMAT(start_time,'%p') as stime, "
			+ "		extract(hour from end_time) as endhr,DATE_FORMAT(end_time,'%p')  as etime, "
			+ "        duration as duration "
			+ "      from callcenter "
			+ "      group by extract(hour from start_time),DATE_FORMAT(start_time,'%p'),extract(hour from end_time),DATE_FORMAT(end_time,'%p') "
			+ "     ) t "
			+ "order by duration desc "
			+ "limit 1")
	public String findLongestCallHours();
	
	
	@Query(value="select starthr result from (select extract(day from start_time) as starthr, count(*) as cnt from callcenter "
			+ "group by extract(day from start_time)) t  order by cnt desc  limit 1")
	public String findCallValumeHighestDays();
	
	
	@Query(value="select starthr result from (select extract(day from start_time) as starthr, duration as duration from callcenter "
			+ "group by extract(day from start_time)) t  order by duration desc  limit 1")
	public String findLongestCallDays();

}
