package com.demo.jpa2.service;

import com.demo.jpa2.domain.dao.StudentDao;
import java.util.List;

public interface StudentService {

  List<StudentDao> getStudents();

  StudentDao getStudent(String email);

  void registerStudent(StudentDao student);

  void updateStudentProfile(StudentDao student, String email);

  void deleteStudentProfile(String email);
}
