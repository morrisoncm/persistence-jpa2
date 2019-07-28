package com.demo.jpa2.service;

import java.util.List;

import com.demo.jpa2.domain.Subject;

public interface SubjectService {

	List<Subject> getSubjects();
	
	Subject getSubject(String name);

	void registerSubject(Subject subject);
	
	void updateSubject(Subject subject);
	
	void deleteSubject(String name);
}
