package com.demo.jpa2.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;
import com.demo.jpa2.dao.ProfessorRepository;
import com.demo.jpa2.domain.Professor;
import com.demo.jpa2.service.ProfessorService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProfessorServiceImpl implements ProfessorService {

  @Autowired
  private ProfessorRepository professorRepository;

  @Override
  public List<Professor> getProfessors() {
    return professorRepository.findAll();
  }

  @Override
  public Professor getProfessor(String email) {
    return professorRepository.findByEmail(email);
  }

  @Override
  public void registerProfessor(Professor professor) {
    if (!ObjectUtils.isEmpty(getProfessor(professor.getEmail()))) {
      log.error("registerProfessor() -> exception professor {} found", professor);
      throw new ResponseStatusException(HttpStatus.FOUND, "Professor Found");
    }
    try {
      professorRepository.save(professor);
    } catch (final Exception cause) {
      log.error("registerProfessor() -> professor {}", professor, cause);
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Professor Not Created");
    }
    professorRepository.save(professor);
  }

  @Override
  public void updateProfessorProfile(Professor professor, String email) {
    final var professorFromDb = getProfessor(email);
    if (ObjectUtils.isEmpty(professorFromDb)) {
      log.error("updateProfessorProfile() -> exception for professor {} and email {}, because not found", professor, email);
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Professor Not Found");
    }
    try {
      professor.setEmail(email);
      professor.setId(professorFromDb.getId());
      professorRepository.save(professor);
    } catch (final Exception cause) {
      log.error("updateProfessorProfile() -> exception for student {}", professor,  cause);
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Professor Not Updated");
    }
  }

  @Override
  public void deleteProfesorProfile(String email) {
    final var professorFromDb = getProfessor(email);
    if (ObjectUtils.isEmpty(professorFromDb)) {
      log.error("deleteProfesorProfile() -> exception for email {} because not found", email);
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Professor Not Found");
    }
    try {
      professorRepository.delete(professorFromDb);
    } catch (final Exception cause) {
      log.error("deleteProfesorProfile() -> exception for professorFromDb {}", professorFromDb,  cause);
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student Not Updated");
    }
  }

}
