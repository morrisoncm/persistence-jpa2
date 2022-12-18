package com.demo.jpa2.controller;

import com.demo.jpa2.domain.dao.ProfessorDAO;
import com.demo.jpa2.service.ProfessorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jpa2/professors")
public class ProfessorController {

  @Autowired
  private ProfessorService professorService;

  @GetMapping
  public List<ProfessorDAO> getProfessors() {
    return professorService.getProfessors();
  }

  @GetMapping("/{email:.+}")
  public ProfessorDAO getProfessor(@PathVariable String email) {
    return professorService.getProfessor(email);
  }

  @PostMapping
  public void registerProfessor(@RequestBody ProfessorDAO professor) {
    professorService.registerProfessor(professor);
  }

  @PutMapping("/{email:.+}")
  public void updateProfessorProfile(
      @RequestBody ProfessorDAO professor,
      @PathVariable String email
  ) {
    professorService.updateProfessorProfile(professor, email);
  }

  @DeleteMapping("/{email:.+}")
  public void deleteProfesorProfile(@PathVariable String email) {
    professorService.deleteProfesorProfile(email);
  }
}
