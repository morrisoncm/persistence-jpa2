package com.demo.jpa2.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {

  private String firstname;
  private String lastname;
  private String email;
  private SubjectDto subject;

}
