package com.demo.jpa2.service;

import com.demo.jpa2.domain.dao.StudentDAO;
import java.util.List;

public interface StudentService {

  List<StudentDAO> getStudents();

  StudentDAO getStudent(String email);

  void registerStudent(StudentDAO student);

  void updateStudentProfile(StudentDAO student, String email);

  void deleteStudentProfile(String email);
}
