package com.demo.jpa2.domain.jpa;

import com.demo.jpa2.domain.dao.ProfessorDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorDao, Long> {

  ProfessorDao findByEmail(String email);

}
