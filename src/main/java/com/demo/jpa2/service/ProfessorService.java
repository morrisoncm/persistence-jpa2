package com.demo.jpa2.service;

import com.demo.jpa2.domain.dao.ProfessorDao;
import java.util.List;

public interface ProfessorService {

  List<ProfessorDao> getProfessors();

  ProfessorDao getProfessor(String email);

  void registerProfessor(ProfessorDao professor);

  void updateProfessorProfile(ProfessorDao professor, String email);

  void deleteProfesorProfile(String email);
}
