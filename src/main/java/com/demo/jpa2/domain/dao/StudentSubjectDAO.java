package com.demo.jpa2.domain.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "students_subjects")
public class StudentSubjectDAO {


  private Long subjectId;
  private SubjectDAO subject;

}
