package com.demo.jpa2.domain.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "professors_subjects")
public class ProfessorSubjectDAO {

  private Long professorid;
  private SubjectDAO subject;

}
