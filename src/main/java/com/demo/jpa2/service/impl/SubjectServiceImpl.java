package com.demo.jpa2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.demo.jpa2.dao.SubjectRepository;
import com.demo.jpa2.domain.Subject;
import com.demo.jpa2.service.SubjectService;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;

	@Override
	public List<Subject> getSubjects() {
		return subjectRepository.findAll();
	}

	@Override
	public Subject getSubject(String name) {
		Subject subjectFromDb = subjectRepository.findSubjectByName(name);
		if (ObjectUtils.isEmpty(subjectFromDb)) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "Subject does not exist!");
		}
		return subjectFromDb;
	}

	@Override
	public void registerSubject(Subject subject) {
		Subject subjectFromDb = subjectRepository.findSubjectByName(subject.getName());
		if (!ObjectUtils.isEmpty(subjectFromDb)) {
			throw new ResponseStatusException(
					HttpStatus.FORBIDDEN, "Subject already exists!");
		}
		subjectRepository.save(subject);
	}

	@Override
	public void updateSubject(Subject subject) {
		Subject subjectFromDb = getSubject(subject.getName());
		subject.setId(subjectFromDb.getId());
		subjectRepository.save(subject);
	}

	@Override
	public void deleteSubject(String name) {
		Subject subjectFromDb = getSubject(name);
		subjectRepository.delete(subjectFromDb);
	}
}