package com.demo.jpa2.controller;

import com.demo.jpa2.domain.dto.ProfessorDto;
import com.demo.jpa2.domain.entity.Professor;
import com.demo.jpa2.mapping.DtoToEntity;
import com.demo.jpa2.mapping.EntityToDto;
import com.demo.jpa2.service.ProfessorService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
  public List<ProfessorDto> getProfessors() {
    List<Professor> professors = professorService.getProfessors();
    return EntityToDto.getProfessors(professors);
  }

  @GetMapping("/{email:.+}")
  public ProfessorDto getProfessor(@PathVariable String email) {
    Professor professor = professorService.getProfessor(email);
    return EntityToDto.getProfessor(professor);
  }

  @PostMapping
  public void registerProfessor(@Validated @RequestBody ProfessorDto professorDto) {
    professorDto.setCreateDate(LocalDate.now());
    Professor professor = DtoToEntity.getProfessor(professorDto);
    professorService.registerProfessor(professor);
  }

  @PutMapping("/{email:.+}")
  public void updateProfessorProfile(@Validated @RequestBody ProfessorDto professorDto,
      @PathVariable String email) {
    professorDto.setEditDate(LocalDate.now());
    Professor professor = DtoToEntity.getProfessor(professorDto);
    professorService.updateProfessorProfile(professor, email);
  }

  @DeleteMapping("/{email:.+}")
  public void deleteProfesorProfile(@PathVariable String email) {
    professorService.deleteProfesorProfile(email);
  }

}
