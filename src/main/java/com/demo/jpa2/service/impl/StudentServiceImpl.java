package com.demo.jpa2.service.impl;

import com.demo.jpa2.domain.jpa.StudentRepository;
import com.demo.jpa2.domain.dao.StudentDao;
import com.demo.jpa2.service.StudentService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  private StudentRepository studentRepository;

  @Override
  public List<StudentDao> getStudents() {
    return studentRepository.findAll();
  }

  @Override
  public StudentDao getStudent(String email) {
    return studentRepository.findByEmail(email);
  }

  @Override
  public void registerStudent(StudentDao student) {
    if (!ObjectUtils.isEmpty(getStudent(student.getEmail()))) {
      log.error("registerStudent() -> exception student {} found", student);
      throw new ResponseStatusException(HttpStatus.FOUND, "Student Found");
    }
    try {
      studentRepository.save(student);
    } catch (final Exception cause) {
      log.error("registerStudent() -> student {}", student, cause);
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student Not Created");
    }
  }

  @Override
  public void updateStudentProfile(StudentDao student, String email) {
    final var studentFromDb = getStudent(email);
    if (ObjectUtils.isEmpty(studentFromDb)) {
      log.error(
          "updateStudentProfile() -> exception for student {} and email {}, because not found",
          student, email);
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student Not Found");
    }
    try {
      student.setEmail(email);
      student.setId(studentFromDb.getId());
      studentRepository.save(student);
    } catch (final Exception cause) {
      log.error("updateStudentProfile() -> exception for student {}", student, cause);
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student Not Updated");
    }
  }

  @Override
  public void deleteStudentProfile(String email) {
    final var studentFromDb = getStudent(email);
    if (ObjectUtils.isEmpty(studentFromDb)) {
      log.error("updateStudentProfile() -> exception for email {} because not found", email);
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student Not Found");
    }
    try {
      studentRepository.delete(studentFromDb);
    } catch (final Exception cause) {
      log.error("updateStudentProfile() -> exception for studentFromDb {}", studentFromDb, cause);
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student Not Updated");
    }
  }

}
