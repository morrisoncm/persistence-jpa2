package com.demo.jpa2.mappings;

import static org.apache.commons.beanutils.BeanUtils.copyProperties;

import com.demo.jpa2.domain.dto.StudentDto;
import com.demo.jpa2.domain.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class DtoToEntity {

  public static Student getStudent(StudentDto studentDto) {
    try {
      Student student = new Student();
      copyProperties(student, studentDto);
      return student;
    } catch (Exception cause) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student mapping failed");
    }
  }

}
