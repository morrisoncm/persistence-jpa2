package com.demo.jpa2.service.impl;

import com.demo.jpa2.domain.entity.Subject;
import com.demo.jpa2.service.SubjectService;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {

  @Override
  public Subject getSubject(String subjectName) {
    return null;
  }

  @Override
  public Set<Subject> getSubjects() {
    return null;
  }

  @Override
  public void addSubject(Subject subject) {

  }

  @Override
  public void updateSubject(Subject subject) {

  }

  @Override
  public void deleteSubject(String subjectName) {

  }

}
