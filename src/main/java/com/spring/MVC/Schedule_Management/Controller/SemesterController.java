package com.spring.MVC.Schedule_Management.Controller;

import com.spring.MVC.Schedule_Management.Entity.Course;
import com.spring.MVC.Schedule_Management.Entity.Semester;
import com.spring.MVC.Schedule_Management.model.AddSemesterModel;
import com.spring.MVC.Schedule_Management.service.CourseService;
import com.spring.MVC.Schedule_Management.service.SemesterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/semester")
public class SemesterController {

    private SemesterService semesterService;

    private CourseService courseService;

    public SemesterController(SemesterService semesterService, CourseService courseService) {
        this.semesterService = semesterService;
        this.courseService = courseService;
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String submitData(@ModelAttribute("semester") AddSemesterModel addSemesterModel) {
        semesterService.saveData(addSemesterModel);
        return "redirect:/index/semester";

    }


    @GetMapping("/addsemester")
    public String add(Model model) {
        List<Semester> semesterList = semesterService.ListAll();
        List<Course> courseList = courseService.listAll();
        model.addAttribute("semesterList", semesterList);
        model.addAttribute("courseList", courseList);
        model.addAttribute("semester", new AddSemesterModel());

        return "addsemester";
    }


    @RequestMapping(value = "/edit/{semesterId}")
    public ModelAndView Edit(@PathVariable long semesterId) {
        ModelAndView modelAndView = new ModelAndView("addsemester");
        List<Course> courseList = courseService.listAll();
        AddSemesterModel updateSemesterModel = semesterService.Edit(semesterId);
        modelAndView.addObject("semester", updateSemesterModel);
        modelAndView.addObject("courseList", courseList);
        return modelAndView;
    }


    @RequestMapping("/delete/{semesterId}")
    public String delete(@PathVariable long semesterId) {
        semesterService.delete(semesterId);
        return "redirect:/index/semester";
    }


}