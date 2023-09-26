package com.spring.MVC.Schedule_Management.repository;


import com.spring.MVC.Schedule_Management.Entity.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TeacherRepo extends JpaRepository<Teachers,Long> {

Teachers findByTeacherEmail(String teacherEmail);

    Set<Teachers> findAllByIdIn(Set<Long>teachersIds);


}
