package com.demo.jpa2.service.impl;

import com.demo.jpa2.domain.entity.Student;
import com.demo.jpa2.repository.StudentRepository;
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
  public List<Student> getStudents() {
    List<Student> students = studentRepository.findAll();
    return null;
  }

  @Override
  public Student getStudent(String email) {
    Student student = studentRepository.findByEmail(email);
    return null;
  }

  @Override
  public void registerStudent(Student student) {
    if (!ObjectUtils.isEmpty(getStudent(student.getEmail()))) {
      log.error("registerStudent() -> exception student {} 302 found", student);
      throw new ResponseStatusException(HttpStatus.FOUND, "Student found");
    }
    try {
      studentRepository.save(student);
    } catch (final Exception cause) {
      log.error("registerStudent() -> student {}", student, cause);
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student not created");
    }
  }

  @Override
  public void updateStudentProfile(Student student, String email) {
    final var studentFromDb = studentRepository.findByEmail(email);
    if (ObjectUtils.isEmpty(studentFromDb)) {
      log.error(
          "updateStudentProfile() -> exception for student {} and email {} 404 not found",
          student, email);
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
    }
    try {
      studentRepository.save(null);
    } catch (final Exception cause) {
      log.error("updateStudentProfile() -> exception for student {}", null, cause);
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student not updated");
    }
  }

  @Override
  public void deleteStudentProfile(String email) {
    final var studentFromDb = studentRepository.findByEmail(email);
    if (ObjectUtils.isEmpty(studentFromDb)) {
      log.error("updateStudentProfile() -> exception for email {} because not found", email);
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student email not found");
    }
    try {
      studentRepository.delete(studentFromDb);
    } catch (final Exception cause) {
      log.error("updateStudentProfile() -> exception for studentFromDb {}", studentFromDb, cause);
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student found but update failed");
    }
  }

}
