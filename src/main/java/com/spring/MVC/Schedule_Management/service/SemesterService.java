package com.spring.MVC.Schedule_Management.service;
;

import com.spring.MVC.Schedule_Management.Entity.Semester;
import com.spring.MVC.Schedule_Management.model.AddSemesterModel;

import java.util.List;

public interface SemesterService {
    void saveData(AddSemesterModel addSemesterModel);

    List<Semester> ListAll();


    AddSemesterModel Edit(long ids);

    void delete(long semesterId);


    List<Semester> listAll();
}
