package com.demo.jpa2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.jpa2.domain.Subject;
import com.demo.jpa2.service.SubjectService;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	
	@GetMapping
	public List<Subject> getSubjects() {
		return subjectService.getSubjects();
	}

	@GetMapping("/{name}")
	public Subject getSubject(@PathVariable String name) {
		return subjectService.getSubject(name);
	}

	@PostMapping
	public void registerSubject(@RequestBody Subject subject) {
		subjectService.registerSubject(subject);
	}

	@PutMapping("/{name}")
	public void updateSubject(@PathVariable String name, @RequestBody Subject subject) {
		subject.setName(name);
		subjectService.updateSubject(subject);
	}

	@DeleteMapping("/{name}")
	public void deleteSubject(@PathVariable String name) {
		subjectService.deleteSubject(name);
	}
}
