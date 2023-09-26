package com.spring.MVC.Schedule_Management.Controller;


import com.spring.MVC.Schedule_Management.model.CourseTeacherModel;
import com.spring.MVC.Schedule_Management.model.SemesterCourse;
import com.spring.MVC.Schedule_Management.projection.EnrolledTeacherProjection;
import com.spring.MVC.Schedule_Management.projection.SemesterProjection;
import com.spring.MVC.Schedule_Management.repository.CourseTeacherRepo;
import com.spring.MVC.Schedule_Management.repository.SemesterRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller

public class IndexController {

    private SemesterRepo semesterRepo;

    private CourseTeacherRepo courseTeacherRepo;

    public IndexController(SemesterRepo semesterRepo, CourseTeacherRepo courseTeacherRepo) {
        this.semesterRepo = semesterRepo;
        this.courseTeacherRepo = courseTeacherRepo;
    }


    @RequestMapping( "/index")
    public String indexPage(Model model){
        model.addAttribute("title","Index");
        return "index";
    }





    @GetMapping("/semester")
    public String homePage(Model model){
        List<SemesterCourse> list=new ArrayList<>();
        //  semesterRepo.findSchedule().forEach(semesterProjection -> System.out.println(semesterProjection.getSemesterName()));
        for (SemesterProjection semester :semesterRepo.findSchedule()){
            SemesterCourse course=new SemesterCourse();
            course.setSemesterId(semester.getSemesterId());
            course.setSemesterName(semester.getSemesterName());
            course.setCourseCode(semester.getCourseCode());
            course.setCourseName(semester.getCourseName());
            course.setYear(semester.getYear());
            list.add(course);
        }

        model.addAttribute("semesterList",list);
        return "semester";

    }


    @RequestMapping(value = "/enrolledteacher",method = RequestMethod.GET)
    public String Homepage(Model model){
        List<CourseTeacherModel> courseTeacherModelList=new ArrayList<>();
        for(EnrolledTeacherProjection enrolledTeacherProjection:courseTeacherRepo.enrolledTeacher()){
            CourseTeacherModel s=new CourseTeacherModel();
            s.setId(enrolledTeacherProjection.getId());
            s.setTeacherAcro(enrolledTeacherProjection.getTeacherAcro());
            s.setCourseCode(enrolledTeacherProjection.getCourseCode());
            s.setCourseName(enrolledTeacherProjection.getCourseName());
            s.setSemesterName(enrolledTeacherProjection.getSemesterName());
            s.setSectionName(enrolledTeacherProjection.getSectionName());
            courseTeacherModelList.add(s);
        }
        model.addAttribute("enrolledTeacherList",courseTeacherModelList);
        return "enrolledteacher";

    }


}
