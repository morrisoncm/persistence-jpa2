package com.demo.jpa2.service.impl;

import com.demo.jpa2.domain.entity.Subject;
import com.demo.jpa2.repository.SubjectRepository;
import com.demo.jpa2.service.SubjectService;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {

  @Autowired
  private SubjectRepository subjectRepository;

  @Override
  public List<Subject> getSubjects() {
    return subjectRepository.findAll(Sort.by(Sort.Direction.ASC, "subjectName"));
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
    subject.setCreateDate(LocalDate.now());
    subjectRepository.save(subject);
  }

  @Override
  public void deleteSubjectProfile(String subjectName) {
    Subject subject = subjectRepository.findBySubjectName(subjectName);
    subjectRepository.delete(subject);
  }

}
