package com.demo.jpa2.service;

import java.util.List;
import com.demo.jpa2.domain.Professor;

public interface ProfessorService {

  List<Professor> getProfessors();

  Professor getProfessor(String email);

  void registerProfessor(Professor professor);

  void updateProfessorProfile(Professor professor, String email);

  void deleteProfesorProfile(String email);
}
