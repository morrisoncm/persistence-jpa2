package com.demo.jpa2.domain.jpa;

import com.demo.jpa2.domain.dao.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

  Professor findByEmail(String email);

}
