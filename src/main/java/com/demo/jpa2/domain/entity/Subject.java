package com.demo.jpa2.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Subject {

  @Getter(AccessLevel.NONE)
  private Long id;
  @Column(name = "subject_name")
  private String subjectName;
  @Column(name = "description")
  private String description;

  @JoinTable(
      name = "student_subjects",
      joinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(
          name = "student_id",
          referencedColumnName = "id"
      )
  )
  @ManyToMany
  private Set<Student> students;

  @JoinTable(
      name = "professor_subjects",
      joinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(
          name = "professor_id",
          referencedColumnName = "id"
      )
  )
  @ManyToOne
  private Professor professor;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long getId() {
    return id;
  }

}
