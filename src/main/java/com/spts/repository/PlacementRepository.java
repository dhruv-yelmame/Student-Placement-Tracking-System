package com.spts.repository;

import java.util.List;

import com.spts.model.Placement;

public interface PlacementRepository {

	List<Placement> getAllPlacements();

	boolean updatePlacementStatus(int pid, String status);

	boolean applyCompany(int sid, int cid);

	boolean withdrawCompany(int sid, int cid);

	boolean isAlreadyApplied(int sid, int cid);

	List<Object[]> getStudentPlacements(int sid);

	String getApplicationStatus(int sid, int cid);
}