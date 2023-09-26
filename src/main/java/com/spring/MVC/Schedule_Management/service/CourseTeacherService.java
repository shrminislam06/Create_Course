package com.spring.MVC.Schedule_Management.service;


import com.spring.MVC.Schedule_Management.model.AddCourseTeacher;

public interface CourseTeacherService {

    void save(AddCourseTeacher addCourseTeacher);

    void delete(long id);

    AddCourseTeacher Edit(long id);
}
