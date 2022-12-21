package com.demo.jpa2.domain.repository;

import com.demo.jpa2.domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

  Student findByEmail(String email);

}
