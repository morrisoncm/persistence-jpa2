package com.demo.jpa2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.jpa2.domain.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {

	Subject findSubjectByName(String name);
}