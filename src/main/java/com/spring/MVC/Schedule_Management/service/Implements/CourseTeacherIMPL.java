package com.spring.MVC.Schedule_Management.service.Implements;
import com.spring.MVC.Schedule_Management.Entity.*;
import com.spring.MVC.Schedule_Management.model.AddCourseTeacher;
import com.spring.MVC.Schedule_Management.repository.*;
import com.spring.MVC.Schedule_Management.service.CourseTeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CourseTeacherIMPL implements CourseTeacherService {
private TeacherRepo teacherRepo;
private SemesterRepo semesterRepo;
    private CourseRepo courseRepo;
    private CourseTeacherRepo courseTeacherRepo;
    private SectionRepo sectionRepo;
    private  RoomRepo roomRepo;

    public CourseTeacherIMPL(TeacherRepo teacherRepo, SemesterRepo semesterRepo, CourseRepo courseRepo, CourseTeacherRepo courseTeacherRepo, SectionRepo sectionRepo, RoomRepo roomRepo) {
        this.teacherRepo = teacherRepo;
        this.semesterRepo = semesterRepo;
        this.courseRepo = courseRepo;
        this.courseTeacherRepo = courseTeacherRepo;
        this.sectionRepo = sectionRepo;
        this.roomRepo = roomRepo;
    }

    @Override
    public void save(AddCourseTeacher addCourseTeacher) {

        // checking the courses are present in the db or not
        Set<Course> courseList = courseRepo.findAllByIdIn(addCourseTeacher.getCourseIds());
        Teachers teachers = teacherRepo.findById(addCourseTeacher.getTeachersIds())
                .orElseThrow(() -> new RuntimeException("Teacher not found with id:" + addCourseTeacher.getTeachersIds()));
        Semester semester =semesterRepo.findById(addCourseTeacher.getSemesterIds())
                .orElseThrow(() -> new RuntimeException("Semester not found with id:"+ addCourseTeacher.getSemesterIds()));
        Section section=sectionRepo.findById(addCourseTeacher.getSectionIds())
                .orElseThrow(()->new RuntimeException("section not found"+addCourseTeacher.getSectionIds()));
        Set<EnrolledTeacher> enrolledTeachers = courseList.stream().map(course -> {
            EnrolledTeacher enrolledTeacher = new EnrolledTeacher();
            enrolledTeacher.setCourses(new ArrayList<>(courseList).get(0));
            enrolledTeacher.setTeachers(teachers);
            enrolledTeacher.setSemesters(semester);
            enrolledTeacher.setSections(section);
            return enrolledTeacher;
        }).collect(Collectors.toSet());


        courseTeacherRepo.saveAll(enrolledTeachers);
    }



    @Override
    public void delete(long Id) {
        courseTeacherRepo.deleteById(Id);
    }

    @Override
    public AddCourseTeacher Edit(long id) {
        Teachers teachers = teacherRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id:" + id));
        Semester semester = semesterRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("semester not found with id:" + id));
        Section section=sectionRepo.findById(id).orElseThrow(()->new RuntimeException("section noy found"+id));
        Set<Long> courses = courseTeacherRepo.getByTeachers(teachers)
                .stream().map((enrolledTeacher) -> enrolledTeacher.getCourses().getId())
                .collect(Collectors.toSet());
        AddCourseTeacher addCourseTeacher=new AddCourseTeacher();
        addCourseTeacher.setCourseIds(courses);
        addCourseTeacher.setTeachersIds(id);
        addCourseTeacher.setSectionIds(id);
        addCourseTeacher.setSemesterIds(id);

        return addCourseTeacher;

    }
}
