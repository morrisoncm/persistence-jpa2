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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Getter
@Setter
@Entity
@Table(name = "subject")
@JsonInclude(Include.NON_NULL)
public class ProfessorSubject {

    @Id
    @Column(name = "sub_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long subjectId;
    @Column(name = "subject_name")
    @Max(50)
    private String subjectName;
    @Column(name = "description")
    @Max(300)
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = ISO.DATE, pattern = "yyyy-MM-dd")
    @Column(name = "create_date", nullable = false)
    private LocalDate createDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = ISO.DATE, pattern = "yyyy-MM-dd")
    @Column(name = "edit_date")
    private LocalDate editDate;
    @JsonIgnore
    @JoinTable(
            name = "professor_subject",
            joinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "sub_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "professor_id",
                    referencedColumnName = "p_id"
            )
    )
    @ManyToOne
    @Valid
    private Professor subjectProfessor;

}
