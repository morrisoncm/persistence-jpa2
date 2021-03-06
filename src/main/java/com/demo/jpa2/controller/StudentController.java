package com.demo.jpa2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.demo.jpa2.domain.Student;
import com.demo.jpa2.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping()
	public List<Student> getStudents() {
		return studentService.getStudents();
	}

	@PostMapping
	public void registerStudent(@RequestBody Student student) {
		studentService.registerStudent(student);
	}

	@GetMapping("/{registration}")
	public Student getStudent(@PathVariable String registration) {
		return studentService.getStudent(registration);
	}

	@PutMapping("/{registration}")
	public void updateProfile(@PathVariable String registration, @RequestBody Student student) {
		student.setRegistration(registration);
		studentService.updateStudentProfile(student);
	}

	@DeleteMapping("/{registration}")
	public void deleteProfile(@PathVariable String registration) {
		studentService.deleteStudentProfile(registration);
	}
}