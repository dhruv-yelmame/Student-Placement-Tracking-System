package com.spts.service;

import java.util.List;

import com.spts.model.Company;
import com.spts.repository.CompanyRepository;
import com.spts.repository.CompanyRepositoryImpl;

public class CompanyServiceImpl implements CompanyService {

	private CompanyRepository repo = new CompanyRepositoryImpl();

	@Override
	public boolean addCompany(Company c) {
		return repo.addCompany(c);
	}

	@Override
	public List<Company> getAllCompanies() {
		return repo.getAllCompanies();
	}

	@Override
	public boolean deleteCompany(int cid) {
		return repo.deleteCompany(cid);
	}

	@Override
	public Company getCompanyById(int cid) {
		return repo.getCompanyById(cid);
	}

	@Override
	public boolean updateCompany(Company c) {
		return repo.updateCompany(c);
	}
}