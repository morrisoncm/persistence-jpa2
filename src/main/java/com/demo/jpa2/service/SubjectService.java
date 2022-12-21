package com.demo.jpa2.service;

import com.demo.jpa2.domain.entity.Subject;
import java.util.Set;

public interface SubjectService {

  Subject getSubject(String subjectName);

  Set<Subject> getSubjects();

  void addSubject(Subject subject);

  void updateSubject(Subject subject);

  void deleteSubject(String subjectName);

}
