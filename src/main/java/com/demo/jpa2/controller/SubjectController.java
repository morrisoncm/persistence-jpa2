package com.demo.jpa2.controller;

import com.demo.jpa2.domain.dto.SubjectDto;
import com.demo.jpa2.domain.entity.Subject;
import com.demo.jpa2.mappings.EntityToDto;
import com.demo.jpa2.service.SubjectService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
  public List<SubjectDto> getSubjects() {
    List<Subject> subjects = subjectService.getSubjects();
    return EntityToDto.getSubjects(subjects);
  }

  @GetMapping("/{subjectName}")
  public SubjectDto getSubject(@PathVariable String subjectName) {
    Subject subject = subjectService.getSubject(subjectName);
    return EntityToDto.getSubject(subject);
  }

  @PostMapping
  public void createSubject(@RequestBody @Validated Subject subject) {
    subject.setCreateDate(LocalDate.now());
    subjectService.createSubject(subject);
  }

  @PutMapping("/{subjectName}")
  public void updateSubjectProfile(@RequestBody @Validated Subject subject,
      @PathVariable String subjectName) {
    subject.setEditDate(LocalDate.now());
    subjectService.updateSubjectProfile(subject, subjectName);
  }

  @DeleteMapping("/{subjectName}")
  public void deleteSubjectProfile(@PathVariable String subjectName) {
    subjectService.deleteSubjectProfile(subjectName);
  }

}
