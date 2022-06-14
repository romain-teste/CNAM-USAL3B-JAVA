package com.CH.DB.JPA.DAO;

import java.util.List;

import javax.sql.DataSource;


import com.CH.DB.JPA.mapper.StepMapper;
import com.CH.DB.JPA.table.TableStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StepDAO extends JdbcDaoSupport {
	
	@Autowired
	public StepDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	//
	public List <TableStep> getChasseTresoreStep(int numberScenario) {
		String sql = StepMapper.BASE_SQL+ " WHERE s_scenario=" + numberScenario ;
		Object[] params = new Object[] {};
		StepMapper mapper= new StepMapper();
		List<TableStep> list= this.getJdbcTemplate().query(sql, params, mapper);
		
		return list;
	}
}