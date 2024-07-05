package com.demo.jpa2.repository;

import com.demo.jpa2.domain.entity.Professor;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    Professor findByEmail(String email);

    @Query(value = "SELECT p FROM Professor p WHERE p.email IN :emails")
    List<Professor> findProfessorByEmailList(Collection<String> emails);

}
