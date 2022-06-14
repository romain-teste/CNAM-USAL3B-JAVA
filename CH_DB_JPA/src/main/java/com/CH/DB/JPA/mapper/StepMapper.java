package com.CH.DB.JPA.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;


import com.CH.DB.JPA.table.TableStep;

import org.springframework.jdbc.core.RowMapper;

public class StepMapper implements RowMapper <TableStep> {
	public static final String BASE_SQL ="SELECT s_id, s_scenario, s_number, s_title, s_description, s_response, s_type FROM table_step";



	@Override
	public TableStep mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id = rs.getInt("s_id");
		int scenario = rs.getInt("s_scenario");
		int number = rs.getInt("s_number");
		String title = rs.getString("s_title");
		String description = rs.getString("s_description");
		String response = rs.getString("s_response");
		String type = rs.getString("s_type");

		return new TableStep(id, scenario, number, title, description, response, type);
	}
}