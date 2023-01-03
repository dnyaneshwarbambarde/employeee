package com.marketingapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp.dto.LeadData;
import com.marketingapp.entities.Lead;
import com.marketingapp.services.Leadservices;
import com.marketingapp.util.EmailServices;
import com.marketingapp.util.EmailServicesImpl;

@Controller
public class LeadController {
	@Autowired
	private Leadservices leadServices;
	
	@Autowired
	 EmailServices mailservices;

	
     
	@RequestMapping("/createLead")
	public String viewCreateLeadPage() {
		return "create_new_lead";
	}
	@RequestMapping("/savelead")
	public String saveoneLead(@ModelAttribute("lead") Lead lead , ModelMap model) {
		leadServices.saveLead(lead);
		mailservices.sendEmail(lead.getEmail(),"sub","welcome");
		model.addAttribute("saveMsg", "Record is saved!!");
	return"create_new_lead";
	}

	@RequestMapping("/listleads")
	public String getAllLeads(ModelMap model) {
		List<Lead> leads = leadServices.listAll();
		model.addAttribute("leads", leads);
		return "search_result";
	}
	@RequestMapping("/delete")
	public String deleteOneLead(@RequestParam("id") long id ,ModelMap model) {
		leadServices.deleteLeadById(id);
		List<Lead> leads = leadServices.listAll();
		model.addAttribute("leads", leads);
		return "search_result";
		
	}
	@RequestMapping("/	")
	public String updateOneLead(@RequestParam("id") long id ,ModelMap model) {
		Lead lead = leadServices.findOneLeadById(id);
		if (lead!=null) {
			model.addAttribute("lead", lead);
			return "update_lead";	
		}else {
			model.addAttribute("error", "No record found");
			return "error_page";
		}
		
	}
	@RequestMapping("/updatelead")
	public String updateLead(LeadData data , ModelMap model) {
		Lead lead = new Lead();
	      lead.setId(data.getId());
	      lead.setFirstName(data.getFirstName());
	      lead.setLastName(data.getLastName());
	      lead.setEmail(data.getEmail());
	      lead.setMobile(data.getMobile());
	      List<Lead> leads = leadServices.listAll();
			model.addAttribute("leads", leads);
			return "search_result";
	}
}
