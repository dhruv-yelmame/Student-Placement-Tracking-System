package com.spts.repository;

import java.util.List;

import com.spts.model.Student;

public interface StudentRepository {

	List<Student> getAllStudents();

	Student getStudentProfile(int sid);

	boolean updateProfile(Student s);
}