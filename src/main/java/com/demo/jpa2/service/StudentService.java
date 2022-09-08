package com.demo.jpa2.service;

import java.util.List;
import com.demo.jpa2.domain.Student;

public interface StudentService {

  List<Student> getStudents();

  Student getStudent(String email);

  void registerStudent(Student student);

  void updateStudentProfile(Student student, String email);

  void deleteStudentProfile(String email);
}
