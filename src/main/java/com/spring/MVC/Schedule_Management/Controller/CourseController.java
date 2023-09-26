package com.spring.MVC.Schedule_Management.Controller;
import com.spring.MVC.Schedule_Management.Entity.Course;
import com.spring.MVC.Schedule_Management.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/course")

public class CourseController {

    private CourseService courseService;


    public CourseController(CourseService courseService) {
        this.courseService = courseService;

    }

    @GetMapping("/course")
    public String homePage(Model model){
        List<Course>courseList=courseService.listAll();
        model.addAttribute("courseList",courseList);
        return "course";
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveCourse(@ModelAttribute("course")Course course){
        courseService.save(course);

        return "redirect:addcourse";
    }

    @RequestMapping(value = "/course/edit/{id}")
    public ModelAndView Edit(@PathVariable("id")long id){
        ModelAndView modelAndView=new ModelAndView("addcourse");
        Course course=courseService.get(id);
        modelAndView.addObject("course",course);
        return modelAndView;
    }
    @RequestMapping( "/course/delete/{id}")
    public String delete(@PathVariable("id")long id){
        courseService.delete(id);
        return "redirect:/course/course";
    }

    @GetMapping("/addcourse")
    private String getCourse(Model model){
        List<Course>courseList=courseService.listAll();
        model.addAttribute("courselist",courseList);
        model.addAttribute("course" ,new Course());
        return "addcourse";

    }




    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}