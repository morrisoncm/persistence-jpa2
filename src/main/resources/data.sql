INSERT INTO student (firstName, lastName, email) VALUES
('Carole', 'Singer', 'csinger@myuniversity.edu'),
('Justin', 'Thyme', 'jthyme@myuniversity.edu');

INSERT INTO professor (title, firstName, lastName, email) VALUES
('Dr.', 'Jay', 'Walker', 'jwalker@myuniversity.edu'),
('Dr.', 'Jack', 'Pott', 'jpott@myuniversity.edu');


INSERT INTO subject (name, description) VALUES
('Maths', 'Teaching and learning how to solve problems using algorithms and formulas necessary for computations.'),
('English', 'Analyzing short stories and  novels including nonfiction, drama, poems, and myths'),
('Physics', 'The concepts of vectors and scalars using the kinematic equations, graphs of motion, and reference frames and relative motions');

INSERT INTO students_subjects (studentId, subjectid) VALUES 
(SELECT id from student WHERE email = 'csinger@myuniversity.edu', SELECT id FROM subject WHERE name = 'Maths'),
(SELECT id from student WHERE email = 'csinger@myuniversity.edu', SELECT id FROM subject WHERE name = 'English'),
(SELECT id from student WHERE email = 'jthyme@myuniversity.edu', SELECT id FROM subject WHERE name = 'Maths'),
(SELECT id from student WHERE email = 'jthyme@myuniversity.edu', SELECT id FROM subject WHERE name = 'Physics');

INSERT INTO professors_subjects (professorid, subjectid) VALUES 
(SELECT id from professor WHERE email = 'jpott@myuniversity.edu', SELECT id FROM subject WHERE name = 'Maths'),
(SELECT id from professor WHERE email = 'jpott@myuniversity.edu', SELECT id FROM subject WHERE name = 'English'),
(SELECT id from professor WHERE email = 'jwalker@myuniversity.edu', SELECT id FROM subject WHERE name = 'Maths'),
(SELECT id from professor WHERE email = 'jwalker@myuniversity.edu', SELECT id FROM subject WHERE name = 'Physics'); 