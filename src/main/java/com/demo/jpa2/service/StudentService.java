package com.demo.jpa2.service;

import java.util.List;

import com.demo.jpa2.domain.Student;

public interface StudentService {

	List<Student> getStudents();

	Student getStudent(String registration);

	void registerStudent(Student student);

	void updateStudentProfile(Student student);

	void deleteStudentProfile(String registration);
}