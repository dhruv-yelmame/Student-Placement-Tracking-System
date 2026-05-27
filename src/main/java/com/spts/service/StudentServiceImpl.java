package com.spts.service;

import java.util.List;

import com.spts.model.Student;
import com.spts.repository.StudentRepository;
import com.spts.repository.StudentRepositoryImpl;

public class StudentServiceImpl implements StudentService {

	private StudentRepository repo = new StudentRepositoryImpl();

	@Override
	public List<Student> getAllStudents() {

		return repo.getAllStudents();
	}

	@Override
	public Student getStudentProfile(int sid) {

		return repo.getStudentProfile(sid);
	}

	@Override
	public boolean updateProfile(Student s) {

		return repo.updateProfile(s);
	}
	
	@Override
	public boolean deleteStudent(int sid) {

		return repo.deleteStudent(sid);
	}
}