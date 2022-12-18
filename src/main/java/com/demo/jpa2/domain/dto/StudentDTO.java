package com.demo.jpa2.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO {

  private String firstname;
  private String lastname;
  private String email;
  private SubjectDTO subject;

}
