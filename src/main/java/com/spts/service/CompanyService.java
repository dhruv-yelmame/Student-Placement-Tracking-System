package com.spts.service;

import java.util.List;

import com.spts.model.Company;

public interface CompanyService {

	boolean addCompany(Company c);

	List<Company> getAllCompanies();

	boolean deleteCompany(int cid);
	
    Company getCompanyById(int cid);
	
    boolean updateCompany(Company c);

}