package com.demo.jpa2.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Student {

  @Id
  @Column(name = "stu_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long studentId;
  @Column(name = "firstname")
  private String firstname;
  @Column(name = "lastname")
  private String lastname;
  @Column(name = "email")
  private String email;
  @ManyToMany(mappedBy = "enrolledStudents")
  private Set<EnrolledSubject> enrolledSubjects = new HashSet<>();

}
