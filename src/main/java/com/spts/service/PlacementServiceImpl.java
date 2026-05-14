package com.spts.service;

import java.util.List;

import com.spts.model.Placement;

import com.spts.repository.PlacementRepository;
import com.spts.repository.PlacementRepositoryImpl;

public class PlacementServiceImpl implements PlacementService {

	private PlacementRepository repo = new PlacementRepositoryImpl();

	@Override
	public List<Placement> getAllPlacements() {

		return repo.getAllPlacements();
	}

	@Override
	public boolean updatePlacementStatus(int pid, String status) {

		return repo.updatePlacementStatus(pid, status);
	}

	@Override
	public boolean applyCompany(int sid, int cid) {

		return repo.applyCompany(sid, cid);
	}

	@Override
	public boolean withdrawCompany(int sid, int cid) {

		return repo.withdrawCompany(sid, cid);
	}

	@Override
	public boolean isAlreadyApplied(int sid, int cid) {

		return repo.isAlreadyApplied(sid, cid);
	}

	@Override
	public List<Object[]> getStudentPlacements(int sid) {

		return repo.getStudentPlacements(sid);
	}
}