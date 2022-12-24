package com.demo.jpa2.controller;

import com.demo.jpa2.domain.entity.Student;
import com.demo.jpa2.service.StudentService;
import jakarta.validation.Valid;
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
  public List<Student> getStudents() {
    return studentService.getStudents();
  }

  @GetMapping("/{email:.+}")
  public Student getStudent(@PathVariable String email) {
    return studentService.getStudent(email);
  }

  @PostMapping
  public void enrollStudent(@Valid @RequestBody Student student) {
    studentService.enrollStudent(student);
  }

  @PutMapping("/{email:.+}")
  public void updateStudentProfile(@Valid @RequestBody Student student,
      @PathVariable String email) {
    studentService.updateStudentProfile(student, email);
  }

  @DeleteMapping("/{email}")
  public void deleteStudentProfile(@PathVariable String email) {
    studentService.deleteStudentProfile(email);
  }

}
