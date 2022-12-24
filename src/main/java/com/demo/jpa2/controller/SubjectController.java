package com.demo.jpa2.controller;

import com.demo.jpa2.domain.entity.Subject;
import com.demo.jpa2.service.SubjectService;
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

@RestController
@RequestMapping("/jpa2/subjects")
public class SubjectController {

  @Autowired
  private SubjectService subjectService;

  @GetMapping
  public List<Subject> getSubjects() {
    return subjectService.getSubjects();
  }

  @GetMapping("/{subjectName}")
  public Subject getSubject(@PathVariable String subjectName) {
    return subjectService.getSubject(subjectName);
  }

  @PostMapping
  public void createSubject(@RequestBody Subject subject) {
    subjectService.createSubject(subject);
  }

  @PutMapping("/{subjectName}")
  public void updateSubjectProfile(@RequestBody Subject subject, @PathVariable String subjectName) {
    subjectService.updateSubjectProfile(subject, subjectName);
  }

  @DeleteMapping("/{subjectName}")
  public void deleteSubjectProfile(@PathVariable String subjectName) {
    subjectService.deleteSubjectProfile(subjectName);
  }

}
