package com.demo.jpa2.service.impl;

import com.demo.jpa2.domain.entity.Professor;
import com.demo.jpa2.repository.ProfessorRepository;
import com.demo.jpa2.service.ProfessorService;
import jakarta.transaction.Transactional;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
@Transactional
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public List<Professor> getProfessors() {
        return professorRepository.findAll(Sort.by(Sort.Direction.ASC, "email"));
    }

    @Override
    public Professor getProfessor(String email) {
        return professorRepository.findByEmail(email);
    }

    @Override
    public void registerProfessor(Professor professor) {
        if (!ObjectUtils.isEmpty(getProfessor(professor.getEmail()))) {
            log.error("registerProfessor() -> exception professor {} found", professor);
            throw new ResponseStatusException(HttpStatus.FOUND, "Professor Found");
        }
        try {
            professorRepository.save(professor);
        } catch (final Exception cause) {
            log.error("registerProfessor() -> professor {}", professor, cause);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Professor Not Created");
        }
        professorRepository.save(professor);
    }

    @Override
    public void updateProfessorProfile(Professor professor, String email) {
        final var professorFromDb = getProfessor(email);
        if (ObjectUtils.isEmpty(professorFromDb)) {
            log.error(
                    "updateProfessorProfile() -> exception for professor {} and email {}, because not found",
                    professor,
                    email);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Professor Not Found");
        }
        try {
            professor.setProfessorId(professorFromDb.getProfessorId());
            professorRepository.save(professor);
        } catch (final Exception cause) {
            log.error("updateProfessorProfile() -> exception for student {}", professor, cause);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Professor Not Updated");
        }
    }

    @Override
    public void deleteProfesorProfile(String email) {
        final var professorFromDb = getProfessor(email);
        if (ObjectUtils.isEmpty(professorFromDb)) {
            log.error("deleteProfesorProfile() -> exception for email {} because not found", email);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Professor Not Found By Email");
        }
        try {
            professorRepository.delete(professorFromDb);
        } catch (final Exception cause) {
            log.error("deleteProfesorProfile() -> exception for professorFromDb {}", professorFromDb,
                    cause);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student Not Updated");
        }
    }

}
