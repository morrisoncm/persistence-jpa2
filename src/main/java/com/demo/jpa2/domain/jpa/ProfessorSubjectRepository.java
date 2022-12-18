package com.demo.jpa2.domain.jpa;

import com.demo.jpa2.domain.dao.ProfessorSubjectDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorSubjectRepository extends JpaRepository<ProfessorSubjectDao, Long> {

}
