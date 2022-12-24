package com.demo.jpa2.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "subject")
public class ProfessorSubject {

  @Id
  @JsonIgnore
  @Column(name = "sub_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long subjectId;
  @Column(name = "subject_name")
  private String subjectName;
  @Column(name = "description")
  private String description;
  @JsonIgnore
  @JoinTable(
      name = "professor_subject",
      joinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "sub_id"),
      inverseJoinColumns = @JoinColumn(
          name = "professor_id",
          referencedColumnName = "p_id"
      )
  )
  @ManyToOne
  private Professor subjectProfessor;

}
