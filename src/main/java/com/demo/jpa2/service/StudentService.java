package com.demo.jpa2.service;

import com.demo.jpa2.domain.entity.Student;
import java.util.List;

public interface StudentService {

  List<Student> getStudents();

  Student getStudent(String email);

  void enrollStudent(Student student);

  void updateStudentProfile(Student student, String email);

  void deleteStudentProfile(String email);

}
