package com.demo.jpa2.domain.jpa;

import com.demo.jpa2.domain.dao.StudentSubjectDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentSubjectRepository extends JpaRepository<StudentSubjectDAO, Long> {

}
