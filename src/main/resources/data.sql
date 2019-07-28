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

INSERT INTO student (registration, password, firstName, lastName, email) VALUES
('2091245678', 'password', 'John', 'Doe', 'johndoe@gmail.com'),
('7895612349', 'xyz1234', 'Jane', 'Doe', 'janedoe@yahoo.com');


INSERT INTO subject (name, description) VALUES
('Mathematics', 'Teaching and learning how to solve problems using algorithms and formulas necessary for computations.'),
('English', 'Analyzing short stories and  novels including nonfiction, drama, poems, and myths'),
('Physics', 'The concepts of vectors and scalars using the kinematic equations, graphs of motion, and reference frames and relative motions');