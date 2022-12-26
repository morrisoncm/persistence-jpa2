drop table IF EXISTS student, professor, subject, student_subject, professor_subject;

create TABLE student (
  stu_id INT AUTO_INCREMENT PRIMARY KEY,
  firstname VARCHAR(50) NOT NULL,
  lastname VARCHAR(50) NOT NULL,
  email VARCHAR(75) NOT NULL,
  create_date DATE NOT NULL,
  edit_date DATE

);

create TABLE professor (
  p_id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(10) NOT NULL,
  firstname VARCHAR(50) NOT NULL,
  lastname VARCHAR(50) NOT NULL,
  email VARCHAR(75) NOT NULL,
  create_date DATE NOT NULL,
  edit_date DATE
);

create TABLE subject (
  sub_id INT AUTO_INCREMENT PRIMARY KEY,
  subject_name VARCHAR(75) NOT NULL,
  description VARCHAR (300) NOT NULL,
  create_date DATE NOT NULL,
  edit_date DATE
);

create TABLE student_subject (
  student_id INT, FOREIGN KEY (student_id) REFERENCES student(stu_id),
  subject_id INT, FOREIGN KEY (subject_id) REFERENCES subject(sub_id),
  create_date DATE NOT NULL,
  edit_date DATE
);

create TABLE professor_subject (
  professor_id INT, FOREIGN KEY (professor_id) REFERENCES professor(p_id),
  subject_id INT, FOREIGN KEY (subject_id) REFERENCES subject(sub_id),
  create_date DATE NOT NULL,
  edit_date DATE
);
