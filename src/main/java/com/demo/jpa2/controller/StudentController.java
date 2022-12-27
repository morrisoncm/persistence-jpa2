package com.demo.jpa2.controller;

import com.demo.jpa2.domain.dto.StudentDto;
import com.demo.jpa2.domain.entity.Student;
import com.demo.jpa2.mappings.EntityToDto;
import com.demo.jpa2.service.StudentService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
  public List<StudentDto> getStudents() {
    List<Student> students = studentService.getStudents();
    return EntityToDto.getStudents(students);
  }

  @GetMapping("/{email:.+}")
  public StudentDto getStudent(@PathVariable String email) {
    Student student = studentService.getStudent(email);
    return EntityToDto.getStudent(student);
  }

  @PostMapping
  public void enrollStudent(@RequestBody @Validated Student student) {
    student.setCreateDate(LocalDate.now());
    studentService.enrollStudent(student);
  }

  @PutMapping("/{email:.+}")
  public void updateStudentProfile(@RequestBody @Validated Student student,
      @PathVariable String email) {
    student.setEditDate(LocalDate.now());
    studentService.updateStudentProfile(student, email);
  }

  @DeleteMapping("/{email}")
  public void deleteStudentProfile(@PathVariable String email) {
    studentService.deleteStudentProfile(email);
  }

}
