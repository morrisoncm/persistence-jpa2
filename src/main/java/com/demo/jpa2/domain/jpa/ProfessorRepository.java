package com.demo.jpa2.domain.jpa;

import com.demo.jpa2.domain.dao.ProfessorDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorDAO, Long> {

  ProfessorDAO findByEmail(String email);

}
