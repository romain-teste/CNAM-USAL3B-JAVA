package com.CH.DB.JPA.DAO;

import java.util.List;

import javax.sql.DataSource;


import com.CH.DB.JPA.mapper.ChasseTresorMapper;
import com.CH.DB.JPA.table.TableSenario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ChasseTresorDAO extends JdbcDaoSupport {
	
	@Autowired
	public ChasseTresorDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	public List <TableSenario> getChasseTresore() {
		String sql = ChasseTresorMapper.BASE_SQL;
		Object[] params = new Object[] {};
		ChasseTresorMapper mapper= new ChasseTresorMapper();
		List<TableSenario> list= this.getJdbcTemplate().query(sql, params, mapper);
		
		return list;
	}
	
	public void setStepAjout(int idScenario) {
		String sql = "update table_senario u set u.se_step = u.se_step + 1 where u.se_id = " + idScenario;
		getJdbcTemplate().update(sql);
		
	}
	
	public void setStepSuppr(int idScenario) {
		String sql = "update table_senario u set u.se_step = u.se_step - 1 where u.se_id = " + idScenario;
		getJdbcTemplate().update(sql);
		
	}
	
}