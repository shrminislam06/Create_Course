package com.spring.MVC.Schedule_Management.Controller;


import com.spring.MVC.Schedule_Management.Entity.Course;
import com.spring.MVC.Schedule_Management.Entity.Section;
import com.spring.MVC.Schedule_Management.Entity.Semester;
import com.spring.MVC.Schedule_Management.Entity.Teachers;
import com.spring.MVC.Schedule_Management.model.AddCourseTeacher;
import com.spring.MVC.Schedule_Management.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/enrolledteacher")
public class CourseTeacherController {

    private CourseService courseService;
    private CourseTeacherService courseTeacherService;
    private SemesterService semesterService;

    private TeacherService teacherService;

    private SectionService sectionService;
    private RoomService roomService;

    public CourseTeacherController(CourseService courseService, CourseTeacherService courseTeacherService, SemesterService semesterService, TeacherService teacherService, SectionService sectionService, RoomService roomService) {
        this.courseService = courseService;
        this.courseTeacherService = courseTeacherService;
        this.semesterService = semesterService;
        this.teacherService = teacherService;
        this.sectionService = sectionService;
        this.roomService = roomService;
    }

    @RequestMapping(value = "/addcourseTeacher",method = RequestMethod.GET)
    public String SaveData(Model model){
        List<Teachers>teacherList=teacherService.listAll();
        List<Course>courseList=courseService.listAll();
        List<Semester>semesterList=semesterService.ListAll();
        List<Section>sectionList=sectionService.ListAll();
        model.addAttribute("teacherList",teacherList);
        model.addAttribute("courseList",courseList);
        model.addAttribute("semesterList",semesterList);
        model.addAttribute("sectionList",sectionList);
        model.addAttribute("enrolledteacher",new AddCourseTeacher());
        return "addcourseTeacher";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String Save(@ModelAttribute("enrolledteacher") AddCourseTeacher addCourseTeacher){
        courseTeacherService.save(addCourseTeacher);
        return "redirect:/index/enrolledteacher";
    }
    @RequestMapping(value = "/edit/{id}")
    public ModelAndView Edit(@PathVariable long id, @ModelAttribute AddCourseTeacher addCourseTeacher,
                             RedirectAttributes attributes){
        attributes.addFlashAttribute("update successfull");
        ModelAndView modelAndView=new ModelAndView("addcourseTeacher");
        List<Course>courseList=courseService.listAll();
        List<Teachers>teachersList=teacherService.listAll();
        List<Semester>semesterList=semesterService.ListAll();
        List<Section>sectionList=sectionService.ListAll();
        AddCourseTeacher updateCourseTeacher = courseTeacherService.Edit(id);
        modelAndView.addObject("enrolledteacher",updateCourseTeacher);
        modelAndView.addObject("courseList",courseList);
        modelAndView.addObject("semesterList",semesterList);
        modelAndView.addObject("teachersList",teachersList);
        modelAndView.addObject("sectionList",sectionList);
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id")long id){
        courseTeacherService.delete(id);
        return "redirect:/index/enrolledteacher";
    }


}
