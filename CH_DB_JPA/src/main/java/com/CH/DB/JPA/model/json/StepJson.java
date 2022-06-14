package com.CH.DB.JPA.model.json;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.CH.DB.JPA.table.TableStep;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "scenario", "number", "title", "description", "response", "type" })
public class StepJson {
	@JsonIgnore
	private TableStep step;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<>();
	
	public StepJson() {
	}

	public StepJson(TableStep step) {
		this.step = step;
	}
	
	public int getScenario() {
		return step.getScenario();
	}
	
	public void setScenario(int s_scenario) {
		step.setScenario(s_scenario);
	}
	
	public int getNumber() {
		return step.getNumber();
	}
	
	public void setNumber(int s_number) {
		step.setScenario(s_number);
	}
	
	public String getTitle() {
		return step.getTitle();
	}
	
	public void setTitle(String s_title) {
		step.setTitle(s_title);;
	}
	
	public String getDescription() {
		return step.getDescription();
	}
	
	public void setDescription(String s_description) {
		step.setDescription(s_description);;
	}
	
	public String getResponse() {
		return step.getResponse();
	}
	
	public void setResponse(String s_response) {
		step.setResponse(s_response);;
	}
	
	public String getType() {
		return step.getType();
	}
	
	public void setType(String s_type) {
		step.setType(s_type);
	}
	
	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@JsonIgnore
	public TableStep getStep() {
		return step;
	}

	@JsonIgnore
	public void setStep(TableStep step) {
		this.step = step;
	}
	
}