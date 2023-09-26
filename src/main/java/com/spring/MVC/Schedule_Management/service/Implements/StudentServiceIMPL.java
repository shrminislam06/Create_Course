package com.spring.MVC.Schedule_Management.service.Implements;

import com.spring.MVC.Schedule_Management.Entity.Student;
import com.spring.MVC.Schedule_Management.repository.StudentRepo;
import com.spring.MVC.Schedule_Management.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceIMPL implements StudentService {

    private StudentRepo studentRepository;


    public StudentServiceIMPL(StudentRepo studentRepository) {
        this.studentRepository = studentRepository;

    }

    @Override
    public List<Student> listAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student get(long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void delete(long id) {
    studentRepository.deleteById(id);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateData(long id)
    {
        return studentRepository.findById(id).get();
    }







}
