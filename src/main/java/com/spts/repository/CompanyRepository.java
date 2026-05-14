package com.spts.repository;

import java.util.List;

import com.spts.model.Company;

public interface CompanyRepository {

	boolean addCompany(Company c);

	List<Company> getAllCompanies();

	boolean deleteCompany(int cid);
	
	Company getCompanyById(int cid);
	
	boolean updateCompany(Company c);
}