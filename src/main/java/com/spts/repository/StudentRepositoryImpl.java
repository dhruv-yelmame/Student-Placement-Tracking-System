package com.spts.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import com.spts.model.Student;

public class StudentRepositoryImpl extends DBConfig implements StudentRepository {

	@Override
	public List<Student> getAllStudents() {

		List<Student> list = new ArrayList<>();

		try {

			PreparedStatement pstmt = conn.prepareStatement("select * from students");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				Student s = new Student();

				s.setSid(rs.getInt("sid"));

				s.setName(rs.getString("name"));

				s.setEmail(rs.getString("email"));

				s.setMobile(rs.getString("mobile"));

				s.setCourse(rs.getString("course"));

				s.setPercentage(rs.getDouble("percentage"));

				s.setSkills(rs.getString("skills"));

				s.setPassword(rs.getString("password"));

				list.add(s);
			}

		} catch (Exception e) {

			System.out.println(e);
		}

		return list;
	}

	@Override
	public Student getStudentProfile(int sid) {

		Student s = null;

		try {

			PreparedStatement pstmt = conn.prepareStatement("select * from students where sid=?");

			pstmt.setInt(1, sid);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				s = new Student();

				s.setSid(rs.getInt("sid"));

				s.setName(rs.getString("name"));

				s.setEmail(rs.getString("email"));

				s.setMobile(rs.getString("mobile"));

				s.setCourse(rs.getString("course"));

				s.setPercentage(rs.getDouble("percentage"));

				s.setSkills(rs.getString("skills"));

				s.setPassword(rs.getString("password"));
			}

		} catch (Exception e) {

			System.out.println(e);
		}

		return s;
	}

	@Override
	public boolean updateProfile(Student s) {

		boolean status = false;

		try {

			PreparedStatement pstmt = conn.prepareStatement(

					"update students set " + "name=?,email=?,mobile=?," + "course=?,percentage=?,skills=? "
							+ "where sid=?"

			);

			pstmt.setString(1, s.getName());

			pstmt.setString(2, s.getEmail());

			pstmt.setString(3, s.getMobile());

			pstmt.setString(4, s.getCourse());

			pstmt.setDouble(5, s.getPercentage());

			pstmt.setString(6, s.getSkills());

			pstmt.setInt(7, s.getSid());

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