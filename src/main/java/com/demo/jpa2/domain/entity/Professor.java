package com.demo.jpa2.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "professor")
public class Professor {

  @Id
  @JsonIgnore
  @Column(name = "p_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long professorId;
  @Column(name = "title")
  private String title;
  @Column(name = "firstname")
  private String firstname;
  @Column(name = "lastname")
  private String lastname;
  @Column(name = "email")
  private String email;
  @OneToMany(mappedBy = "subjectProfessor")
  private Set<ProfessorSubject> professorSubjects = new HashSet<>();

}
