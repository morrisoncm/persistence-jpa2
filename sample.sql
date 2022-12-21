select p1_0.id,p1_0.email,p1_0.firstname,p1_0.lastname,p1_0.title from professor p1_0 where p1_0.email='jwalker@myuniversity.edu'

select p1_0.professor_id,p1_1.id,p1_1.description,p1_1.subject_name,p1_2.professor_id from professor_professor_subjects p1_0 join (subject p1_1 left join professor_subjects p1_2 on p1_1.id=p1_2.subject_id) on p1_1.id=p1_0.professor_subjects_id where p1_0.professor_id=1
