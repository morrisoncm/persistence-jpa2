package com.demo.jpa2.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Getter
@Setter
@Entity
@Table(name = "subject")
public class Subject {

  @Id
  @JsonIgnore
  @Column(name = "sub_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long subjectId;
  @Column(name = "subject_name")
  private String subjectName;
  @Column(name = "description")
  private String description;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @DateTimeFormat(iso = ISO.DATE, pattern = "yyyy-MM-dd")
  @Column(name = "create_date")
  private LocalDate createDate;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @DateTimeFormat(iso = ISO.DATE, pattern = "yyyy-MM-dd")
  @Column(name = "edit_date")
  private LocalDate editDate;

}
