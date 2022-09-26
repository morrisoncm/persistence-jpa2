package com.demo.jpa2.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


@Data
@Entity
@Table(name = "student")
public class Student {

  @Id
  @JsonIgnore
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "firstname")
  private String firstname;
  @Column(name = "lastname")
  private String lastname;
  @Column(name = "email")
  private String email;
  @OneToMany
  @JoinTable(name = "students_subjects", 
  joinColumns = {@JoinColumn(name = "studentid", referencedColumnName = "id")},
  inverseJoinColumns = {@JoinColumn(name = "subjectid", referencedColumnName = "id")})
  private List<Subject> subjects;

}
