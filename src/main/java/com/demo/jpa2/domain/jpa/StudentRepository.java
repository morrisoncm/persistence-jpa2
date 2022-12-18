package com.demo.jpa2.domain.jpa;

import com.demo.jpa2.domain.dao.StudentDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentDAO, Long> {

  StudentDAO findByEmail(String email);

}
