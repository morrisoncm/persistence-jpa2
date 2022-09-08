package com.demo.jpa2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.jpa2.domain.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

  Professor findByEmail(String email);

}
