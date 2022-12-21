package com.demo.jpa2.controller;

import com.demo.jpa2.domain.entity.Subject;
import com.demo.jpa2.service.SubjectService;
import jakarta.validation.Valid;
import java.util.Set;
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

  @GetMapping("/{subjectName}")
  public Subject getSubject(@PathVariable String subjectName) {
    return subjectService.getSubject(subjectName);
  }

  @GetMapping
  public Set<Subject> getSubjects() {
    return subjectService.getSubjects();
  }

  @PostMapping
  public void addSubject(@Valid @RequestBody Subject subject) {
    subjectService.addSubject(subject);
  }

  @PutMapping("/{subjectName}")
  public void updateSubject(@Valid @RequestBody Subject subject,
      @PathVariable String subjectName) {
    subject.setSubjectName(subjectName);
    subjectService.updateSubject(subject);
  }

  @DeleteMapping("/{subjectName}")
  public void deleteSubject(@PathVariable String subjectName) {
    subjectService.deleteSubject(subjectName);
  }

}
