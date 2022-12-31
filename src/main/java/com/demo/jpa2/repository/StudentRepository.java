package com.demo.jpa2.repository;

import com.demo.jpa2.domain.entity.Student;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

  Student findByEmail(String email);

  @Query(value = "SELECT stu FROM Student stu WHERE stu.email IN :emails")
  List<Student> findStudentByEmailList(Collection<String> emails);

}
