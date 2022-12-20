DROP TABLE IF EXISTS student, professor, subject, student_subjects, professor_subjects;

CREATE TABLE student (
  id INT AUTO_INCREMENT PRIMARY KEY,
  firstname VARCHAR(50) NOT NULL,
  lastname VARCHAR(50) NOT NULL,
  email VARCHAR(75) NOT NULL
);

CREATE TABLE professor (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(10) NOT NULL,
  firstname VARCHAR(50) NOT NULL,
  lastname VARCHAR(50) NOT NULL,
  email VARCHAR(75) NOT NULL
);

CREATE TABLE subject (
  id INT AUTO_INCREMENT PRIMARY KEY,
  subject_name VARCHAR(75) NOT NULL,
  description VARCHAR (300) NOT NULL
);

CREATE TABLE student_subjects (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  student_id INT, FOREIGN KEY (student_id) REFERENCES student(id),
  subject_id INT, FOREIGN KEY (subject_id) REFERENCES subject(id)
);

CREATE TABLE professor_subjects (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  professor_id INT, FOREIGN KEY (professor_id) REFERENCES professor(id),
  subject_id INT, FOREIGN KEY (subject_id) REFERENCES subject(id)
);
