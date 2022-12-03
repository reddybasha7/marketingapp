package com.marketing.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marketing.entity.Lead;
import com.marketing.repository.LeadRepository;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/leads")
public class RestController {
	@Autowired
	private LeadRepository leadRepo;
	
	@GetMapping
	public List<Lead> getAllLeadsInApi() {
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}
	
	@PostMapping
	public void saveOneLead(@RequestBody Lead lead) {
		leadRepo.save(lead);
	}
	
	@PutMapping
	public void updateOneLead(@RequestBody Lead lead) {
		leadRepo.save(lead);
	}
	
	
	//http://localhost:8080/api/leads/delete/10
	
	@DeleteMapping("/delete/{id}")
	public void deleteOneLead(@PathVariable("id") long id) {
		leadRepo.deleteById(id);
	}
	
	//http://localhost:8080/api/leads/leadInfo/1
	
	@RequestMapping("/leadInfo/{id}")
	public Lead leadIno(@PathVariable("id") long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}
	
}
