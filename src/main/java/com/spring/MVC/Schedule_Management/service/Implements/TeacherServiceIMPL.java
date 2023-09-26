package com.spring.MVC.Schedule_Management.service.Implements;

import com.spring.MVC.Schedule_Management.Entity.Teachers;
import com.spring.MVC.Schedule_Management.repository.TeacherRepo;
import com.spring.MVC.Schedule_Management.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceIMPL implements TeacherService {
    @Autowired
    private TeacherRepo teacherRepo;

    @Override
    public List<Teachers> listAll() {
        return teacherRepo.findAll();
    }

    @Override
    public void savedata(Teachers teachers) {
        teacherRepo.save(teachers);
    }

    @Override
    public Teachers updateData(long id) {
        return teacherRepo.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        teacherRepo.deleteById(id);
    }
}
