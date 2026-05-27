package com.spts.service;

import java.util.List;

import com.spts.model.Student;

public interface StudentService {

	List<Student> getAllStudents();

	Student getStudentProfile(int sid);

	boolean updateProfile(Student s);
	
	public boolean deleteStudent(int sid);
}