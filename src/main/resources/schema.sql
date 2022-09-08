DROP TABLE IF EXISTS student, professor, subject, students_subjects, professors_subjects;

CREATE TABLE student (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  firstname VARCHAR(50) NOT NULL,
  lastname VARCHAR(50) NOT NULL,
  email VARCHAR(75) NOT NULL
);

CREATE TABLE professor (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  title VARCHAR(10) NOT NULL,
  firstname VARCHAR(50) NOT NULL,
  lastname VARCHAR(50) NOT NULL,
  email VARCHAR(75) NOT NULL
);

CREATE TABLE subject (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(75) NOT NULL,
  description VARCHAR (300) NOT NULL
);

CREATE TABLE students_subjects (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  studentId INT, FOREIGN KEY (studentId) REFERENCES student(id),
  subjectId INT, FOREIGN KEY (subjectId) REFERENCES subject(id)
);

CREATE TABLE professors_subjects (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  professorid INT, FOREIGN KEY (professorid) REFERENCES professor(id),
  subjectId INT, FOREIGN KEY (subjectId) REFERENCES subject(id)
);