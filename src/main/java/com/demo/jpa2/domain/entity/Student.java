package com.demo.jpa2.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {

  @Id
  @JsonIgnore
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
