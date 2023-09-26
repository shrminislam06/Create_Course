package com.spring.MVC.Schedule_Management.repository;

import com.spring.MVC.Schedule_Management.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    Student findByStudentEmail(String studentEmail);

}
