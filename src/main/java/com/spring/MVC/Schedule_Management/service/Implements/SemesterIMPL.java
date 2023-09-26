package com.spring.MVC.Schedule_Management.service.Implements;

import com.spring.MVC.Schedule_Management.Entity.Course;
import com.spring.MVC.Schedule_Management.Entity.Semester;
import com.spring.MVC.Schedule_Management.model.AddSemesterModel;
import com.spring.MVC.Schedule_Management.repository.CourseRepo;
import com.spring.MVC.Schedule_Management.repository.SemesterRepo;
import com.spring.MVC.Schedule_Management.service.SemesterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SemesterIMPL implements SemesterService {

    private SemesterRepo semesterRepo;

    private CourseRepo courseRepo;

    public SemesterIMPL(SemesterRepo semesterRepo, CourseRepo courseRepo) {
        this.semesterRepo = semesterRepo;
        this.courseRepo = courseRepo;
    }

    @Override
    public void saveData(AddSemesterModel addSemesterModel) {

        // checking the courses are present in the db or not
        Set<Course> courseList = courseRepo.findAllByIdIn(addSemesterModel.getCourseIds());
        if (courseList.size() != addSemesterModel.getCourseIds().size()) {
            throw new RuntimeException("Some of course id not present in the system");
        }

        Semester semester = null;
        if (addSemesterModel.getSemesterId() == null) {
            // for saving
            semester = new Semester();
        } else {
            // for updating
            semester = semesterRepo.findById(addSemesterModel.getSemesterId())
                    .orElseThrow(() -> new RuntimeException("Semester not found with id:" + addSemesterModel.getSemesterId()));
        }


        semester.setSemesterName(addSemesterModel.getSemesterName());
        semester.setYear(addSemesterModel.getYear());
        semester.setCourses(courseList);

        semesterRepo.save(semester);
    }

    @Override
    public List<Semester> ListAll() {
        return semesterRepo.findAll();
    }

    @Override
    public AddSemesterModel Edit(long semesterId) {

        // get semester by its id
        Semester semester = semesterRepo.findById(semesterId)
                .orElseThrow(() -> new RuntimeException("Semester not found with id:" + semesterId));

        Set<Long> courses = semester.getCourses().stream().map(Course::getId)
                .collect(Collectors.toSet());

        AddSemesterModel updateSemesterModel = new AddSemesterModel();
        updateSemesterModel.setSemesterId(semesterId);
        updateSemesterModel.setSemesterName(semester.getSemesterName());
        updateSemesterModel.setYear(semester.getYear());
        updateSemesterModel.setCourseIds(courses);

        return updateSemesterModel;

    }


    @Override
    public void delete(long id) {
        semesterRepo.deleteById(id);
    }

    @Override
    public List<Semester> listAll() {
        return semesterRepo.findAll();
    }


}
