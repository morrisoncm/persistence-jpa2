package com.demo.jpa2.domain.jpa;

import com.demo.jpa2.domain.dao.StudentDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentDao, Long> {

  StudentDao findByEmail(String email);

}
