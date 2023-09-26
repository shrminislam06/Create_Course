package com.spring.MVC.Schedule_Management.service;


import com.spring.MVC.Schedule_Management.Entity.Teachers;

import java.util.List;

public interface TeacherService {
    List<Teachers> listAll();

    void savedata(Teachers teachers);

    Teachers updateData(long id);

    void delete(Long id);
}
