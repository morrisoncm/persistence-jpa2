package com.demo.jpa2.repository;

import com.demo.jpa2.domain.entity.Subject;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

  Subject findBySubjectName(String subjectName);

  @Query(value = "SELECT s FROM Subject s WHERE s.subjectname IN :subjectNames")
  List<Subject> findSubjectBySubjectNameList(Collection<String> subjectNames);

}
