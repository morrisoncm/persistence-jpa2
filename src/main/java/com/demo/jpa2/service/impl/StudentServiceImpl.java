package com.demo.jpa2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.demo.jpa2.dao.StudentRepository;
import com.demo.jpa2.domain.Student;
import com.demo.jpa2.service.StudentService;
import org.springframework.web.server.ResponseStatusException;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudent(String registration) {
		Student studentFromDb = studentRepository.findStudentByRegistration(registration);
		if (ObjectUtils.isEmpty(studentFromDb)) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "Student does not exist!");
		}
		return studentFromDb;
	}

	@Override
	public void registerStudent(Student student) {
		Student studentFromDb = studentRepository.findStudentByRegistration(student.getRegistration());
		if (!ObjectUtils.isEmpty(studentFromDb)) {
			throw new ResponseStatusException(
					HttpStatus.FORBIDDEN, "Student already exists!");
		}
		studentRepository.save(student);
	}

	@Override
	public void updateStudentProfile(Student student) {
		Student studentFromDb = getStudent(student.getRegistration());
		student.setId(studentFromDb.getId());
		studentRepository.save(student);
	}

	@Override
	public void deleteStudentProfile(String registration) {
		Student studentFromDb = getStudent(registration);
		studentRepository.delete(studentFromDb);
	}
}