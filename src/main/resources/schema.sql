DROP TABLE IF EXISTS student, professor, subject, students_subjects, professor_subjects;

CREATE TABLE student (
  stu_id INT AUTO_INCREMENT PRIMARY KEY,
  firstname VARCHAR(50) NOT NULL,
  lastname VARCHAR(50) NOT NULL,
  email VARCHAR(75) NOT NULL
);

CREATE TABLE professor (
  p_id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(10) NOT NULL,
  firstname VARCHAR(50) NOT NULL,
  lastname VARCHAR(50) NOT NULL,
  email VARCHAR(75) NOT NULL
);

CREATE TABLE subject (
  sub_id INT AUTO_INCREMENT PRIMARY KEY,
  subject_name VARCHAR(75) NOT NULL,
  description VARCHAR (300) NOT NULL
);

CREATE TABLE students_subjects (
  stu_sub_id INT AUTO_INCREMENT PRIMARY KEY,
  student_id INT, FOREIGN KEY (student_id) REFERENCES student(stu_id),
  subject_id INT, FOREIGN KEY (subject_id) REFERENCES subject(sub_id)
);

CREATE TABLE professor_subjects (
  p_sub_id INT AUTO_INCREMENT PRIMARY KEY,
  professor_id INT, FOREIGN KEY (professor_id) REFERENCES professor(p_id),
  subject_id INT, FOREIGN KEY (subject_id) REFERENCES subject(sub_id)
);
