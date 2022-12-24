package com.demo.jpa2.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "subject")
public class EnrolledSubject {

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
      name = "student_subject",
      joinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "sub_id"),
      inverseJoinColumns = @JoinColumn(
          name = "student_id",
          referencedColumnName = "stu_id"
      )
  )
  @ManyToMany
  private Set<Student> enrolledStudents = new HashSet<>();

}
