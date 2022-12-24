package com.demo.jpa2.service.impl;

import com.demo.jpa2.domain.entity.Subject;
import com.demo.jpa2.domain.repository.SubjectRepository;
import com.demo.jpa2.service.SubjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {

  @Autowired
  private SubjectRepository subjectRepository;

  @Override
  public List<Subject> getSubjects() {
    return subjectRepository.findAll();
  }

  @Override
  public Subject getSubject(String subjectName) {
    return subjectRepository.findBySubjectName(subjectName);
  }

  @Override
  public void createSubject(Subject subject) {
    subjectRepository.save(subject);
  }

  @Override
  public void updateSubjectProfile(Subject subject, String subjectName) {
    Subject subjectFromDb = subjectRepository.findBySubjectName(subjectName);
    subject.setSubjectId(subjectFromDb.getSubjectId());
    subjectRepository.save(subject);
  }

  @Override
  public void deleteSubjectProfile(String subjectName) {
    Subject subject = subjectRepository.findBySubjectName(subjectName);
    subjectRepository.delete(subject);
  }

}
