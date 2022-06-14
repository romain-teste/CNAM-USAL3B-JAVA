package com.CH.DB.JPA.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.CH.DB.JPA.table.TableSenario;
import org.springframework.jdbc.core.RowMapper;

public class ChasseTresorMapper implements RowMapper <TableSenario> {
	public static final String BASE_SQL ="SELECT se_id, se_title, se_description, se_step FROM table_senario";

	public static TableSenario testMM;



	@Override
	public TableSenario mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id = rs.getInt("se_id");
		String title = rs.getString("se_title");
		String description = rs.getString("se_description");
		int step = rs.getInt("se_step");
		return new TableSenario(id, title, description, step);
	}
}