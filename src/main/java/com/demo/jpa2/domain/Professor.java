package com.demo.jpa2.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "professor")
public class Professor {

  @Id
  @JsonIgnore
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "title")
  private String title;
  @Column(name = "firstname")
  private String firstname;
  @Column(name = "lastname")
  private String lastname;
  @Column(name = "email")
  private String email;
  @OneToMany
  @JoinTable(name = "professors_subjects", joinColumns = {
      @JoinColumn(name = "professorid", referencedColumnName = "id")}, inverseJoinColumns = {
      @JoinColumn(name = "subjectid", referencedColumnName = "id")})
  private List<Subject> subjects;

}
