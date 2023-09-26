package com.spring.MVC.Schedule_Management.service;


import com.spring.MVC.Schedule_Management.Entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> listAll();
    Student get(long id);
    void delete(long id);
    Student save(Student student);
    Student updateData(long sid);


}
