package com.demo.jpa2.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class EnrolledSubjectDto {

    private String subjectName;
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = ISO.DATE, pattern = "yyyy-MM-dd")
    private LocalDate createDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = ISO.DATE, pattern = "yyyy-MM-dd")
    private LocalDate editDate;

}
