package com.demo.jpa2.domain.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Subject {

  @Id
  @Column(name = "sub_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long subjectId;
  @Column(name = "subject_name")
  private String subjectName;
  @Column(name = "description")
  private String description;
  @JoinTable(
    name = "students_subjects",
    joinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "sub_id"),
    inverseJoinColumns = @JoinColumn(
      name = "student_id",
      referencedColumnName = "stu_id"
    )
  )
  @ManyToMany
  private Set<Student> enrolledStudents = new HashSet<>();
  @JoinTable(
    name = "professor_subjects",
    joinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "sub_id"),
    inverseJoinColumns = @JoinColumn(
      name = "professor_id",
      referencedColumnName = "p_id"
    )
  )
  @ManyToOne
  private Professor subjectProfessor;

}
