package com.spring.MVC.Schedule_Management.repository;


import com.spring.MVC.Schedule_Management.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {

    Set<Course> findAllByIdIn(Set<Long> courseIds);

}
