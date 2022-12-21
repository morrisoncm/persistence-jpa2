package com.demo.jpa2.repository;

import com.demo.jpa2.domain.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

  Professor findByEmail(String email);

}
