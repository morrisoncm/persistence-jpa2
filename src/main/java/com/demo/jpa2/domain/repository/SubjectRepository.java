package com.demo.jpa2.domain.repository;

import com.demo.jpa2.domain.entity.Subject;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

  Subject findBySubjectName(String subjectName);

  List<Subject> findBySubjectNames(List<String> subjectNames);

}
