package com.demo.jpa2.service;

import com.demo.jpa2.domain.entity.Professor;
import java.util.List;

public interface ProfessorService {

  List<Professor> getProfessors();

  Professor getProfessor(String email);

  void registerProfessor(Professor professor);

  void updateProfessorProfile(Professor professor, String email);

  void deleteProfesorProfile(String email);

}
