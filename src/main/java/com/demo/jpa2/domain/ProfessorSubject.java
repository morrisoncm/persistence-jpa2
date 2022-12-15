package com.demo.jpa2.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "subject")
public class ProfessorSubject {

  @Id
  @JsonIgnore
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "name")
  private String name;
  @Column(name = "description")
  private String description;
  @ManyToMany(
      fetch = FetchType.LAZY,
      cascade = {CascadeType.PERSIST, CascadeType.MERGE}
  )
  @JoinTable(
      name = "professors_subjects",
      joinColumns = {
          @JoinColumn(name = "subjectid", referencedColumnName = "id"),
      },
      inverseJoinColumns = {
          @JoinColumn(name = "professorid", referencedColumnName = "id"),
      }
  )
  private List<Professor> professors;

}
