package com.spring.MVC.Schedule_Management.Controller;


import com.spring.MVC.Schedule_Management.Entity.Course;
import com.spring.MVC.Schedule_Management.Entity.Teachers;
import com.spring.MVC.Schedule_Management.service.CourseService;
import com.spring.MVC.Schedule_Management.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    private TeacherService teacherService;
    private CourseService courseService;

    public TeacherController(TeacherService teacherService, CourseService courseService) {
        this.teacherService = teacherService;
        this.courseService = courseService;
    }


    @GetMapping("/teachers")
    public String homepage(Model model){
        List<Teachers> teachersList=teacherService.listAll();
        model.addAttribute("teachersList",teachersList);
        return "teachers";
    }

    @RequestMapping("/addteacher")
    public String addteacher(Model model){
        List<Teachers>teachersList=teacherService.listAll();
        List<Course>courseList=courseService.listAll();
        model.addAttribute("courseList",courseList);
        model.addAttribute("teachersList",teachersList);
        model.addAttribute("teachers",new Teachers());
        return "addteacher";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String savedata(@ModelAttribute("teachers") Teachers teachers, HttpSession session){
        teacherService.savedata(teachers);
        session.setAttribute("Added successfully",teachers);
        return "redirect:teachers";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView updatedata(@PathVariable("id") long id){
        ModelAndView modelAndView=new ModelAndView("addteacher" );
        Teachers teachers=teacherService.updateData(id);
        modelAndView.addObject("teachers",teachers);
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id")Long id){
        teacherService.delete(id);
        return "teachers";
    }
}

