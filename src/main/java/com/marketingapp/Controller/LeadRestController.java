package com.marketingapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//makes it web services layer in project

import com.marketingapp.entities.Lead;
import com.marketingapp.services.Leadservices;

@RestController
@RequestMapping("/leads")
// to call this call
public class LeadRestController {
	@Autowired
	private Leadservices leadservices;

	@GetMapping
	// convert java object into json object
	public List<Lead> getAllLeads() {
		List<Lead> leads = leadservices.listAll();
		return leads;
	}
	@PostMapping
	 public void saveOneLead(@RequestBody Lead lead) {
		leadservices.saveLead(lead); 
	 }
	@PutMapping
	 public void updateLead(@RequestBody Lead lead) {
		leadservices.saveLead(lead); 
	 }
	@DeleteMapping("/delete/{id}")
	public void deleteOneLead(@PathVariable("id") Long id) {
		leadservices.deleteLeadById(id);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
	 }
	///Developing end points
	@GetMapping("/api/get/{id}")
	public Lead getOneLead(@PathVariable("id") Long id){
		Lead lead = leadservices.findOneLeadById(id);
		return lead;
	}
	

}
