package com.spring.MVC.Schedule_Management.service.Implements;


import com.spring.MVC.Schedule_Management.Entity.Course;
import com.spring.MVC.Schedule_Management.repository.CourseRepo;
import com.spring.MVC.Schedule_Management.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceIMPL implements CourseService {

    private CourseRepo courseRepository;

    public CourseServiceIMPL(CourseRepo courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> listAll() {
        return courseRepository.findAll();
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);

    }

    @Override
    public Course get(long id)
    {
        return courseRepository.findById(id).get();
    }




    @Override
    public void delete(long id) {
        courseRepository.deleteById(id);

    }
}
