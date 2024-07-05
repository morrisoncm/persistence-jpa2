package com.demo.jpa2.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
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
@JsonInclude(Include.NON_NULL)
public class StudentDto {

    @NotBlank
    @Max(50)
    private String firstname;
    @NotBlank
    @Max(50)
    private String lastname;
    @NotBlank
    @Max(75)
    @Email
    private String email;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = ISO.DATE, pattern = "yyyy-MM-dd")
    private LocalDate createDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = ISO.DATE, pattern = "yyyy-MM-dd")
    private LocalDate editDate;
    @Valid
    private Set<EnrolledSubjectDto> enrolledSubjects = new HashSet<>();

}
