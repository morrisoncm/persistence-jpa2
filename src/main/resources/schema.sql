drop table IF EXISTS student, professor, subject, student_subject, professor_subject;

create TABLE school_user (
  u_id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  locked_out INT(1) NOT NULL,
  login_atempts INT(1) NOT NULL,
  active_flag VARCHAR(1) NOT NULL,
  successful_login_date DATE,
  create_date DATE,
  edit_date DATE
);

create TABLE student (
  stu_id INT AUTO_INCREMENT PRIMARY KEY,
  firstname VARCHAR(50) NOT NULL,
  lastname VARCHAR(50) NOT NULL,
  email VARCHAR(75) NOT NULL,
  create_date DATE,
  edit_date DATE
);

create TABLE professor (
  p_id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(10) NOT NULL,
  firstname VARCHAR(50) NOT NULL,
  lastname VARCHAR(50) NOT NULL,
  email VARCHAR(75) NOT NULL,
  create_date DATE,
  edit_date DATE
);

create TABLE subject (
  sub_id INT AUTO_INCREMENT PRIMARY KEY,
  subject_name VARCHAR(50) NOT NULL,
  description VARCHAR (300) NOT NULL,
  create_date DATE,
  edit_date DATE
);

create TABLE student_subject (
  student_id INT, FOREIGN KEY (student_id) REFERENCES student(stu_id),
  subject_id INT, FOREIGN KEY (subject_id) REFERENCES subject(sub_id),
  create_date DATE,
  edit_date DATE
);

create TABLE professor_subject (
  professor_id INT, FOREIGN KEY (professor_id) REFERENCES professor(p_id),
  subject_id INT, FOREIGN KEY (subject_id) REFERENCES subject(sub_id),
  create_date DATE,
  edit_date DATE
);
