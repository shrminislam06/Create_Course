package com.spring.MVC.Schedule_Management.service;


import com.spring.MVC.Schedule_Management.Entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> listAll();

    void delete(long id);

    void save(Course course);

    public Course get(long id);


}
