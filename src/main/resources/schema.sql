DROP TABLE IF EXISTS student, subject, students_subjects;

CREATE TABLE student (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  registration VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  firstname VARCHAR(50) NOT NULL,
  lastname VARCHAR(50) NOT NULL,
  email VARCHAR(75) NOT NULL
);

CREATE TABLE subject (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(75) NOT NULL,
  description VARCHAR(250) NOT NULL
);

CREATE TABLE students_subjects (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  studentId INT, FOREIGN KEY (studentId) REFERENCES student(id),
  subjectId INT, FOREIGN KEY (subjectId) REFERENCES subject(id),
);