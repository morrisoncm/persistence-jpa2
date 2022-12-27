package com.demo.jpa2.domain.dto;

import com.demo.jpa2.domain.entity.EnrolledSubject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.validation.constraints.Email;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class StudentDto {

  private String firstname;
  private String lastname;
  @Email
  private String email;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @DateTimeFormat(iso = ISO.DATE, pattern = "yyyy-MM-dd")
  private LocalDate createDate;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @DateTimeFormat(iso = ISO.DATE, pattern = "yyyy-MM-dd")
  private LocalDate editDate;
  private Set<EnrolledSubject> enrolledSubjects = new HashSet<>();

}
