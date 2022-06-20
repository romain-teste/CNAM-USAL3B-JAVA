package com.CH.DB.JPA.model.json;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import com.CH.DB.JPA.table.TableSenario;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "titre", "description", "step" })
public class ScenarioJson {
	@JsonIgnore
	private TableSenario scenario;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<>();

	public ScenarioJson() {
	}

	public ScenarioJson(TableSenario scenario) {
		this.scenario = scenario;
	}
	
	@JsonProperty("id")
	public int getId() {
		return scenario.getId();
	}

	@JsonProperty("id")
	public void setId(int id) {
		scenario.setId(id);
	}

	@JsonProperty("titre")
	public String getTitle() {
		return scenario.getTitle();
	}

	@JsonProperty("titre")
	public void setTitle(String titre) {
		scenario.setTitle(titre);
	}

	@JsonProperty("description")
	public String getDescription() {
		return scenario.getDescription();
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		scenario.setDescription(description);
	}

	@JsonProperty("step")
	public int getStep() {
		return scenario.getStep();
	}

	@JsonProperty("step")
	public void setStep(int step) {
		scenario.setStep(step);
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
	public TableSenario getScenario() {
		return scenario;
	}

	@JsonIgnore
	public void setScenario(TableSenario scenario) {
		this.scenario = scenario;
	}
}