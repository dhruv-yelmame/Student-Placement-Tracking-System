package com.spts.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import com.spts.model.Placement;

public class PlacementRepositoryImpl extends DBConfig implements PlacementRepository {

	@Override
	public List<Placement> getAllPlacements() {

		List<Placement> list = new ArrayList<>();

		try {

			PreparedStatement pstmt = conn.prepareStatement(

					"SELECT p.pid, s.name, c.company_name, p.apply_date, p.status FROM placements p JOIN students s ON p.sid = s.sid JOIN companies c ON p.cid = c.cid ORDER BY p.pid ASC");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				Placement p = new Placement();

				p.setPid(rs.getInt("pid"));

				p.setStudentName(rs.getString("name"));

				p.setCompanyName(rs.getString("company_name"));

				p.setApply_date(rs.getDate("apply_date"));

				p.setStatus(rs.getString("status"));

				list.add(p);
			}

		} catch (Exception e) {

			System.out.println(e);
		}

		return list;
	}

	@Override
	public boolean updatePlacementStatus(int pid, String status) {

		try {

			PreparedStatement pstmt = conn.prepareStatement(

					"update placements set status=? where pid=?"
			);

			pstmt.setString(1, status);

			pstmt.setInt(2, pid);

			int value = pstmt.executeUpdate();

			if (value > 0) {

				return true;
			}

		} catch (Exception e) {

			System.out.println(e);
		}

		return false;
	}

	@Override
	public boolean applyCompany(int sid, int cid) {

		boolean status = false;

		try {

			PreparedStatement pstmt = conn.prepareStatement(

					"insert into placements (sid,cid,apply_date,status) values(?,?,curdate(),'Applied')");

			pstmt.setInt(1, sid);

			pstmt.setInt(2, cid);

			int val = pstmt.executeUpdate();

			if (val > 0) {

				status = true;
			}

		} catch (Exception e) {

			System.out.println(e);
		}

		return status;
	}

	@Override
	public boolean withdrawCompany(int sid, int cid) {

		boolean status = false;

		try {

			PreparedStatement pstmt = conn.prepareStatement(

					"delete from placements where sid=? and cid=?"

			);

			pstmt.setInt(1, sid);

			pstmt.setInt(2, cid);

			int val = pstmt.executeUpdate();

			if (val > 0) {

				status = true;
			}

		} catch (Exception e) {

			System.out.println(e);
		}

		return status;
	}

	@Override
	public boolean isAlreadyApplied(int sid, int cid) {

		boolean status = false;

		try {

			PreparedStatement pstmt = conn.prepareStatement(

					"select * from placements where sid=? and cid=?"

			);

			pstmt.setInt(1, sid);

			pstmt.setInt(2, cid);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				status = true;
			}

		} catch (Exception e) {

			System.out.println(e);
		}

		return status;
	}

	@Override
	public List<Object[]> getStudentPlacements(int sid) {

		List<Object[]> list = new ArrayList<>();

		try {

			PreparedStatement pstmt = conn.prepareStatement(

				"select p.pid, c.company_name, c.company_package, p.apply_date, p.status from placements p join companies c on p.cid=c.cid where p.sid=?"
			);

			pstmt.setInt(1, sid);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				Object[] obj = new Object[5];

				obj[0] = rs.getInt("pid");

				obj[1] = rs.getString("company_name");

				obj[2] = rs.getString("company_package");

				obj[3] = rs.getDate("apply_date");

				obj[4] = rs.getString("status");

				list.add(obj);
			}

		} catch (Exception e) {

			System.out.println(e);
		}

		return list;
	}

	@Override
	public String getApplicationStatus(int sid, int cid) {

		String status = null;

		try {

			PreparedStatement pstmt = conn.prepareStatement(

					"select status from placements where sid=? and cid=?"

			);

			pstmt.setInt(1, sid);

			pstmt.setInt(2, cid);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				status = rs.getString("status");
			}

		} catch (Exception e) {

			System.out.println(e);
		}

		return status;
	}
}