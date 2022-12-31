package com.demo.jpa2.mapping;

import static org.apache.commons.beanutils.BeanUtils.copyProperties;

import com.demo.jpa2.domain.dto.ProfessorDto;
import com.demo.jpa2.domain.dto.StudentDto;
import com.demo.jpa2.domain.dto.SubjectDto;
import com.demo.jpa2.domain.entity.Professor;
import com.demo.jpa2.domain.entity.Student;
import com.demo.jpa2.domain.entity.Subject;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
public class EntityToDto {

  public static ProfessorDto getProfessor(Professor professor) {
    try {
      ProfessorDto professorDto = new ProfessorDto();
      copyProperties(professorDto, professor);
      return professorDto;
    } catch (Exception cause) {
      log.error("getProfessor() -> mapping failed", cause);
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Professor mapping failed");
    }
  }

  public static List<ProfessorDto> getProfessors(List<Professor> professors) {
    List<ProfessorDto> professorDtos = new ArrayList<>();
    professors.forEach(project -> {
      try {
        ProfessorDto professorDto = new ProfessorDto();
        copyProperties(professorDto, project);
        professorDtos.add(professorDto);
      } catch (Exception cause) {
        log.error("getProfessors() -> mapping failed", cause);
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Professors mapping failed");
      }
    });
    return professorDtos;
  }

  public static SubjectDto getSubject(Subject subject) {
    try {
      SubjectDto subjectDto = new SubjectDto();
      copyProperties(subjectDto, subject);
      return subjectDto;
    } catch (Exception cause) {
      log.error("getSubject() -> mapping failed", cause);
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Subject mapping failed");
    }
  }

  public static List<SubjectDto> getSubjects(List<Subject> subjects) {
    List<SubjectDto> subjectDtos = new ArrayList<>();
    subjects.forEach(subject -> {
      try {
        SubjectDto subjectDto = new SubjectDto();
        copyProperties(subjectDto, subject);
        subjectDtos.add(subjectDto);
      } catch (Exception cause) {
        log.error("getSubjects() -> mapping failed", cause);
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Subjects mapping failed");
      }
    });
    return subjectDtos;
  }

  public static StudentDto getStudent(Student student) {
    try {
      StudentDto studentDto = new StudentDto();
      copyProperties(studentDto, student);
      return studentDto;
    } catch (Exception cause) {
      log.error("getStudent() -> mapping failed", cause);
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student mapping failed");
    }
  }

  public static List<StudentDto> getStudents(List<Student> students) {
    List<StudentDto> studentDtos = new ArrayList<>();
    students.forEach(student -> {
      try {
        StudentDto studentDto = new StudentDto();
        copyProperties(studentDto, student);
        studentDtos.add(studentDto);
      } catch (Exception cause) {
        log.error("getStudents() -> mapping failed", cause);
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Students mapping failed");
      }
    });
    return studentDtos;
  }

}
