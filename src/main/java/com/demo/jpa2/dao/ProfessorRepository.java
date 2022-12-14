package com.demo.jpa2.dao;

import com.demo.jpa2.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

  Professor findByEmail(String email);

}
