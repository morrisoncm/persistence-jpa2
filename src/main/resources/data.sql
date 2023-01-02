insert into student (firstName, lastName, email, create_date, edit_date) values
('Carole', 'Singer', 'csinger@myuniversity.edu', CURRENT_DATE, NULL),
('Justin', 'Thyme', 'jthyme@myuniversity.edu', CURRENT_DATE, NULL),
('Adam', 'Zapel', 'azapel@myuniversity.edu', CURRENT_DATE, NULL),
('Al', 'Bino', 'abino@myuniversity.edu', CURRENT_DATE, NULL),
('Al', 'Dente', 'dente@myuniversity.edu', CURRENT_DATE, NULL),
('Al', 'Fresco', 'afresco@myuniversity.edu', CURRENT_DATE, NULL),
('Al K.', 'Seltzer', 'aseltzer@myuniversity.edu', CURRENT_DATE, NULL),
('Alf A.', 'Romeo', 'aromeo@myuniversity.edu', CURRENT_DATE, NULL),
('Ali', 'Gaither', 'agaither@myuniversity.edu', CURRENT_DATE, NULL),
('Ali', 'Katt', 'akatt@myuniversity.edu', CURRENT_DATE, NULL),
('Amanda', 'Lay', 'alay@myuniversity.edu', CURRENT_DATE, NULL),
('Amanda', 'Lynn', 'alynn@myuniversity.edu', CURRENT_DATE, NULL);

insert into professor (title, firstName, lastName, email, create_date, edit_date) values
('Dr.', 'Jay', 'Walker', 'jwalker@myuniversity.edu', CURRENT_DATE, NULL),
('Dr.', 'Jack', 'Pott', 'jpott@myuniversity.edu', CURRENT_DATE, NULL);

insert into subject (subject_name, description, create_date, edit_date) values
('Maths', 'Teaching and learning how to solve problems using algorithms and formulas necessary for computations.', CURRENT_DATE, NULL),
('English', 'Analyzing short stories and  novels including nonfiction, drama, poems, and myths', CURRENT_DATE, NULL),
('Physics', 'The concepts of vectors and scalars using the kinematic equations, graphs of motion, and reference frames and relative motions', CURRENT_DATE, NULL);

insert into student_subject (student_id, subject_id, create_date, edit_date) values
(select stu_id from student where email = 'csinger@myuniversity.edu', select sub_id from subject where subject_name = 'Maths', CURRENT_DATE, NULL),
(select stu_id from student where email = 'csinger@myuniversity.edu', select sub_id from subject where subject_name = 'English', CURRENT_DATE, NULL),
(select stu_id from student where email = 'jthyme@myuniversity.edu', select sub_id from subject where subject_name = 'Maths', CURRENT_DATE, NULL),
(select stu_id from student where email = 'jthyme@myuniversity.edu', select sub_id from subject where subject_name = 'Physics', CURRENT_DATE, NULL),
(select stu_id from student where email = 'azapel@myuniversity.edu', select sub_id from subject where subject_name = 'Maths', CURRENT_DATE, NULL),
(select stu_id from student where email = 'azapel@myuniversity.edu', select sub_id from subject where subject_name = 'English', CURRENT_DATE, NULL),
(select stu_id from student where email = 'abino@myuniversity.edu', select sub_id from subject where subject_name = 'Maths', CURRENT_DATE, NULL),
(select stu_id from student where email = 'abino@myuniversity.edu', select sub_id from subject where subject_name = 'Physics', CURRENT_DATE, NULL),
(select stu_id from student where email = 'dente@myuniversity.edu', select sub_id from subject where subject_name = 'Maths', CURRENT_DATE, NULL),
(select stu_id from student where email = 'dente@myuniversity.edu', select sub_id from subject where subject_name = 'English', CURRENT_DATE, NULL),
(select stu_id from student where email = 'afresco@myuniversity.edu', select sub_id from subject where subject_name = 'Maths', CURRENT_DATE, NULL),
(select stu_id from student where email = 'afresco@myuniversity.edu', select sub_id from subject where subject_name = 'Physics', CURRENT_DATE, NULL),
(select stu_id from student where email = 'aseltzer@myuniversity.edu', select sub_id from subject where subject_name = 'Maths', CURRENT_DATE, NULL),
(select stu_id from student where email = 'aseltzer@myuniversity.edu', select sub_id from subject where subject_name = 'English', CURRENT_DATE, NULL),
(select stu_id from student where email = 'aromeo@myuniversity.edu', select sub_id from subject where subject_name = 'Maths', CURRENT_DATE, NULL),
(select stu_id from student where email = 'aromeo@myuniversity.edu', select sub_id from subject where subject_name = 'Physics', CURRENT_DATE, NULL),
(select stu_id from student where email = 'agaither@myuniversity.edu', select sub_id from subject where subject_name = 'Maths', CURRENT_DATE, NULL),
(select stu_id from student where email = 'agaither@myuniversity.edu', select sub_id from subject where subject_name = 'English', CURRENT_DATE, NULL),
(select stu_id from student where email = 'alynn@myuniversity.edu', select sub_id from subject where subject_name = 'Maths', CURRENT_DATE, NULL),
(select stu_id from student where email = 'alynn@myuniversity.edu', select sub_id from subject where subject_name = 'Physics', CURRENT_DATE, NULL),
(select stu_id from student where email = 'akatt@myuniversity.edu', select sub_id from subject where subject_name = 'Maths', CURRENT_DATE, NULL),
(select stu_id from student where email = 'akatt@myuniversity.edu', select sub_id from subject where subject_name = 'English', CURRENT_DATE, NULL),
(select stu_id from student where email = 'alay@myuniversity.edu', select sub_id from subject where subject_name = 'Maths', CURRENT_DATE, NULL),
(select stu_id from student where email = 'alay@myuniversity.edu', select sub_id from subject where subject_name = 'Physics', CURRENT_DATE, NULL);


insert into professor_subject (professor_id, subject_id, create_date, edit_date) values
(select p_id from professor where email = 'jpott@myuniversity.edu', select sub_id from subject where subject_name = 'Maths', CURRENT_DATE, NULL),
(select p_id from professor where email = 'jpott@myuniversity.edu', select sub_id from subject where subject_name = 'English', CURRENT_DATE, NULL),
(select p_id from professor where email = 'jwalker@myuniversity.edu', select sub_id from subject where subject_name = 'Physics', CURRENT_DATE, NULL);
