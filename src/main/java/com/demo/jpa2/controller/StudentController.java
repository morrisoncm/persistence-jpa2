package com.demo.jpa2.controller;

import com.demo.jpa2.domain.dao.StudentDao;
import com.demo.jpa2.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jpa2/students")
public class StudentController {

  @Autowired
  private StudentService studentService;

  @GetMapping
  public List<StudentDao> getStudents() {
    return studentService.getStudents();
  }

  @GetMapping("/{email:.+}")
  public StudentDao getStudent(@PathVariable String email) {
    return studentService.getStudent(email);
  }

  @PostMapping
  public void registerStudent(@RequestBody StudentDao student) {
    studentService.registerStudent(student);
  }

  @PutMapping("/{email:.+}")
  public void updateStudentProfile(
      @RequestBody StudentDao student,
      @PathVariable String email
  ) {
    studentService.updateStudentProfile(student, email);
  }

  @DeleteMapping("/{email}")
  public void deleteStudentProfile(@PathVariable String email) {
    studentService.deleteStudentProfile(email);
  }
}
