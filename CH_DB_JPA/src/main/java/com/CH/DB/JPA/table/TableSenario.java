package com.CH.DB.JPA.table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TableSenario {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public
	int se_id;
	public String se_title;
	public String se_description;
	public int se_step;
	public TableSenario(){}
	public TableSenario(int se_id, String se_title, String se_description, int se_step) {
		this.se_id = se_id;
		this.se_title = se_title;
		this.se_description = se_description;
		this.se_step = se_step;
	}
	
	public int getId() {
		return se_id;
	}
	
	public void setId(int se_id) {
		this.se_id = se_id;
	}
	
	public String getTitle() {
		return se_title;
	}
	
	public void setTitle(String se_title) {
		this.se_title = se_title;
	}
	
	public String getDescription() {
		return se_description;
	}
	
	public void setDescription(String se_description) {
		this.se_description = se_description;
	}
	
	public int getStep() {
		return se_step;
	}
	
	public void setStep(int se_step) {
		this.se_step = se_step;
	}
	
}
