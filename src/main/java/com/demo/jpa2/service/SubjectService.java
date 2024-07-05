package com.demo.jpa2.service;

import com.demo.jpa2.domain.entity.Subject;

import java.util.List;

public interface SubjectService {

    List<Subject> getSubjects();

    Subject getSubject(String subjectName);

    void createSubject(Subject subject);

    void updateSubjectProfile(Subject Subject, String subjectName);

    void deleteSubjectProfile(String subjectName);

}
