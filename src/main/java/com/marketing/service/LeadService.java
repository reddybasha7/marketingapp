package com.marketing.service;

import java.util.List;

import com.marketing.entity.Lead;

public interface LeadService {
	public void saveLeadInfo(Lead lead);

	public List<Lead> getLeads();

	public void deleteLead(long id);

	public Lead getOneLead(long id);


	
}
