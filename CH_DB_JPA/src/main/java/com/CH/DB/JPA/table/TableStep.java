package com.CH.DB.JPA.table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TableStep {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public int s_id;
	public int s_scenario;
	public int s_number;
	public String s_title;
	public String s_description;
	public String s_response;
	public String s_type;
	public TableStep(){}
	public TableStep(int s_id, int s_scenario, int s_number, String s_title, String s_description, String s_response, String s_type) {
		this.s_id = s_id;
		this.s_scenario = s_scenario;
		this.s_number = s_number;
		this.s_title = s_title;
		this.s_description = s_description;
		this.s_response = s_response;
		this.s_type = s_type;

	}
	
	public int getId() {
		return s_id;
	}
	
	public void setId(int s_id) {
		this.s_id = s_id;
	}
	
	public int getScenario() {
		return s_scenario;
	}
	
	public void setScenario(int s_scenario) {
		this.s_scenario = s_scenario;
	}
	
	public int getNumber() {
		return s_number;
	}
	
	public void setNumber(int s_number) {
		this.s_number = s_number;
	}
	
	public String getTitle() {
		return s_title;
	}
	
	public void setTitle(String s_title) {
		this.s_title = s_title;
	}
	
	public String getDescription() {
		return s_description;
	}
	
	public void setDescription(String s_description) {
		this.s_description = s_description;
	}
	
	public String getResponse() {
		return s_response;
	}
	
	public void setResponse(String s_response) {
		this.s_response = s_response;
	}
	
	public String getType() {
		return s_type;
	}
	
	public void setType(String s_type) {
		this.s_type = s_type;
	}
	
	
}