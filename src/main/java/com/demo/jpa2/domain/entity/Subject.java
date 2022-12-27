package com.demo.jpa2.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Getter
@Setter
@Entity
@Table(name = "subject")
@JsonInclude(Include.NON_NULL)
public class Subject {

  @Id
  @Column(name = "sub_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonIgnore
  private Long subjectId;
  @Column(name = "subject_name")
  @NotBlank
  @Size(min = 1, max = 50)
  private String subjectName;
  @Column(name = "description")
  @NotBlank
  @Size(min = 1, max = 300)
  private String description;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @DateTimeFormat(iso = ISO.DATE, pattern = "yyyy-MM-dd")
  @Column(name = "create_date", nullable = false)
  private LocalDate createDate;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @DateTimeFormat(iso = ISO.DATE, pattern = "yyyy-MM-dd")
  @Column(name = "edit_date")
  private LocalDate editDate;

}
