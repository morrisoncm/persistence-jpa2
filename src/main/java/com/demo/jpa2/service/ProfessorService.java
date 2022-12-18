package com.demo.jpa2.service;

import com.demo.jpa2.domain.dao.ProfessorDAO;
import java.util.List;

public interface ProfessorService {

  List<ProfessorDAO> getProfessors();

  ProfessorDAO getProfessor(String email);

  void registerProfessor(ProfessorDAO professor);

  void updateProfessorProfile(ProfessorDAO professor, String email);

  void deleteProfesorProfile(String email);
}
