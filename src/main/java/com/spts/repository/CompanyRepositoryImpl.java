package com.spts.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import com.spts.model.Company;

public class CompanyRepositoryImpl extends DBConfig implements CompanyRepository {

	@Override
	public boolean addCompany(Company c) {

		try {

			PreparedStatement pstmt = conn.prepareStatement(
					"insert into companies(company_name,company_package,location,criteria) values(?,?,?,?)");

			pstmt.setString(1, c.getCompany_name());

			pstmt.setString(2, c.getCompany_package());

			pstmt.setString(3, c.getLocation());

			pstmt.setString(4, c.getCriteria());

			int val = pstmt.executeUpdate();

			if (val > 0) {

				return true;
			}

		} catch (Exception e) {

			System.out.println(e);
		}

		return false;
	}

	@Override
	public List<Company> getAllCompanies() {

		List<Company> list = new ArrayList<>();

		try {

			PreparedStatement pstmt = conn.prepareStatement("select * from companies");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				Company c = new Company();

				c.setCid(rs.getInt("cid"));

				c.setCompany_name(rs.getString("company_name"));

				c.setCompany_package(rs.getString("company_package"));

				c.setLocation(rs.getString("location"));

				c.setCriteria(rs.getString("criteria"));

				list.add(c);
			}

		} catch (Exception e) {

			System.out.println(e);
		}

		return list;
	}

	@Override
	public boolean deleteCompany(int cid) {

		boolean status = false;

		try {

			PreparedStatement pstmt = conn.prepareStatement(

					"delete from companies where cid=?");

			pstmt.setInt(1, cid);

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
	public Company getCompanyById(int cid) {

		Company c = null;

		try {

			PreparedStatement pstmt = conn.prepareStatement(

					"select * from companies where cid=?"

			);

			pstmt.setInt(1, cid);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				c = new Company();

				c.setCid(rs.getInt("cid"));

				c.setCompany_name(rs.getString("company_name"));

				c.setCompany_package(rs.getString("company_package"));

				c.setLocation(rs.getString("location"));

				c.setCriteria(rs.getString("criteria"));
			}

		} catch (Exception e) {

			System.out.println(e);
		}

		return c;
	}

	@Override
	public boolean updateCompany(Company c) {

		boolean status = false;

		try {

			PreparedStatement pstmt = conn.prepareStatement(

					"update companies set company_name=?, company_package=?, location=?, criteria=? where cid=?"
			);

			pstmt.setString(1, c.getCompany_name());

			pstmt.setString(2, c.getCompany_package());

			pstmt.setString(3, c.getLocation());

			pstmt.setString(4, c.getCriteria());

			pstmt.setInt(5, c.getCid());

			int val = pstmt.executeUpdate();

			if (val > 0) {

				status = true;
			}

		} catch (Exception e) {

			System.out.println(e);
		}

		return status;

	}
}