package com.demo.jpa2.service.impl;

import com.demo.jpa2.domain.entity.Student;
import com.demo.jpa2.repository.StudentRepository;
import com.demo.jpa2.service.StudentService;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

  @Autowired
  private StudentRepository studentRepository;

  @Override
  public List<Student> getStudents() {
    return studentRepository.findAll(Sort.by(Sort.Direction.ASC, "email"));
  }

  @Override
  public Student getStudent(String email) {
    return studentRepository.findByEmail(email);
  }

  @Override
  public void enrollStudent(Student student) {
    if (!ObjectUtils.isEmpty(getStudent(student.getEmail()))) {
      log.error("registerStudent() -> exception student {} email {} 302 found", student,
          student.getEmail());
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
          "updateStudentProfile() -> exception for student {} and email {} because 404 Not Found",
          student, email);
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
    }
    try {
      student.setStudentId(studentFromDb.getStudentId());
      studentRepository.save(student);
    } catch (final Exception cause) {
      log.error("updateStudentProfile() -> exception for student {} because 400 Bad Request",
          student, cause);
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student not updated");
    }
  }

  @Override
  public void deleteStudentProfile(String email) {
    final var studentFromDb = studentRepository.findByEmail(email);
    if (ObjectUtils.isEmpty(studentFromDb)) {
      log.error("deleteStudentProfile() -> exception for email {} because 404 Not Found", email);
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student email not found");
    }
    try {
      studentRepository.delete(studentFromDb);
    } catch (final Exception cause) {
      log.error("deleteStudentProfile() -> exception for student {}", studentFromDb, cause);
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
          "Student email found although update failed");
    }
  }

}
