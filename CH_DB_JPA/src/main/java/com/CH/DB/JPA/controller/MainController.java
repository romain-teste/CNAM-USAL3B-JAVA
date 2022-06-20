package com.CH.DB.JPA.controller;

import java.util.ArrayList;
import java.util.List;

import com.CH.DB.JPA.SenarioRepo;
import com.CH.DB.JPA.StepRepo;
import com.CH.DB.JPA.DAO.ChasseTresorDAO;
import com.CH.DB.JPA.DAO.StepDAO;
import com.CH.DB.JPA.table.TableSenario;
import com.CH.DB.JPA.table.TableStep;
import com.CH.DB.JPA.model.json.ScenarioJson;
import com.CH.DB.JPA.model.json.StepJson;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

	@Autowired SenarioRepo ob;
	@Autowired StepRepo os;
	@Autowired
	private ChasseTresorDAO chasseTresoreDAO;
	@Autowired
	private StepDAO stepDAO;
	
	private int idScenario=0;
	private int nbrStep=0;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String showChasseTresor(Model model) {
		List <TableSenario> list=chasseTresoreDAO.getChasseTresore();
		model.addAttribute("chasseInfo", list);
		System.out.println();
		return "chassePage";
	}

	@RequestMapping(value="/step/{itemid}/{itemtitle}/{itemStep}", method=RequestMethod.GET)
	public String showStep(@PathVariable("itemid") int itemid,@PathVariable("itemtitle") String itemtitle, @PathVariable("itemStep") int itemStep, Model model) {
		List <TableStep> list=stepDAO.getChasseTresoreStep(itemid); 
		model.addAttribute("scenario", itemid);
		model.addAttribute("scenariotitle", itemtitle);
		model.addAttribute("stepInfo", list);
		idScenario = itemid;
		nbrStep = itemStep;
		return "step";
	}
	
	// SCENARIO -----

	@GetMapping("/ajoutSenario")
	public String ajoutSenario (Model model) {
		model.addAttribute("senario",new TableSenario());
		return "ajoutSenario";
	}
	
	@PostMapping("/testPost")
	public String postChasseTresor(@ModelAttribute TableSenario senario, Model model) {
		TableSenario firstSenario = new TableSenario(senario.se_id, senario.se_title, senario.se_description, senario.se_step);
        ob.save(firstSenario);
        model.addAttribute("senario", senario);
		return "testPost";
	}
	
	@RequestMapping(value="/suppr/{itemid}", method=RequestMethod.GET)
	public String suppretionScenario(@PathVariable("itemid") int itemid) {
		ob.deleteById(itemid);
		return "suppr";
	}
	
	// STEP ----
	
	@GetMapping("/ajout-step/{itemtitle}")
	public String ajoutStep (@PathVariable("itemtitle") String itemtitle,Model model) {
		model.addAttribute("step",new TableStep());
		model.addAttribute("scenariotitle", itemtitle);
		return "ajout-step";
	}
	
	@PostMapping("/step-ajoute/{itemtitle}")
	public String postStep(@ModelAttribute TableStep step,@PathVariable("itemtitle") String itemtitle, Model model) {
		TableStep newStep = new TableStep(step.s_id, idScenario, nbrStep++, step.s_title, step.s_description, step.s_response, step.s_type);
        os.save(newStep);
        model.addAttribute("step", step);
        model.addAttribute("scenariotitle", itemtitle);
        chasseTresoreDAO.setStepAjout(idScenario);
		return "step-ajoute";
	}
		
	@RequestMapping(value="/suppr-step/{itemid}", method=RequestMethod.GET)
	public String suppretionStep(@PathVariable("itemid") int itemid, Model model) {
		os.deleteById(itemid);
		chasseTresoreDAO.setStepSuppr(idScenario);
		model.addAttribute("idStep", itemid);
		return "suppr-step";
	}
	
	// API ------
	@CrossOrigin
	@RequestMapping(value="/api/v1/scenarios", method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<ScenarioJson>> scenarioListJson() {
	List<ScenarioJson> listeScenarios = new ArrayList<ScenarioJson>();
	for (TableSenario scenario : ob.findAll()) {
		listeScenarios.add(new ScenarioJson(scenario));
	}
	return ResponseEntity.ok(listeScenarios);
	}
	
	@CrossOrigin
	@RequestMapping(value="/api/v1/scenarios/{itemid}", method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<ScenarioJson>> scenarioByIdJson(@PathVariable("itemid") int itemid) {
	List<ScenarioJson> listeScenarios = new ArrayList<ScenarioJson>();
	for (TableSenario scenario : ob.findAll()) {
		 if(scenario.se_id == itemid) {
			 listeScenarios.add(new ScenarioJson(scenario));
		 }
	}

	return ResponseEntity.ok(listeScenarios);
	}
	
	@CrossOrigin
	@RequestMapping(value="/api/v1/scenarios/{itemid}/step/{itemnum}", method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<StepJson>> stepNumJson(@PathVariable("itemid") int itemid, @PathVariable("itemnum") int itemnum) {
	List<StepJson> listeStep = new ArrayList<StepJson>();
	for (TableStep step : os.findAll()) {
		if(step.s_scenario == itemid && step.s_number == itemnum) {
			listeStep.add(new StepJson(step));
		}
	}
	return ResponseEntity.ok(listeStep);
	}

	
}