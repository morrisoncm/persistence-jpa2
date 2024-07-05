package com.demo.jpa2.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Getter
@Setter
@Entity
@Table(name = "professor")
@JsonInclude(Include.NON_NULL)
public class Professor {

    @Id
    @Column(name = "p_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long professorId;
    @Column(name = "title")
    @NotBlank
    @Max(10)
    private String title;
    @Column(name = "firstname")
    @NotBlank
    @Max(50)
    private String firstname;
    @Column(name = "lastname")
    @NotBlank
    @Max(50)
    private String lastname;
    @Column(name = "email")
    @NotBlank
    @Max(75)
    @Email
    private String email;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = ISO.DATE, pattern = "yyyy-MM-dd")
    @Column(name = "create_date", nullable = false)
    private LocalDate createDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = ISO.DATE, pattern = "yyyy-MM-dd")
    @Column(name = "edit_date")
    private LocalDate editDate;
    @OneToMany(mappedBy = "subjectProfessor")
    @Valid
    private Set<ProfessorSubject> teachesSubjects = new HashSet<>();

}
