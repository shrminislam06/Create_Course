package com.spring.MVC.Schedule_Management.Controller;


import com.spring.MVC.Schedule_Management.Entity.Student;
import com.spring.MVC.Schedule_Management.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor

public class StudentController {
    @Autowired
    private StudentService studentService;


    @GetMapping("/addstudent")
    public String add(Model model) {
        List<Student> studentList = studentService.listAll();
        model.addAttribute("studentList", studentList);
        model.addAttribute("student", new Student());

        return "addstudent";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.save(student);
        return "redirect:student";
    }

    @RequestMapping(value = "/student/edit/{id}")
    public ModelAndView Edit(@PathVariable("id")long sid){
        ModelAndView modelAndView=new ModelAndView("addstudent");
        Student student=studentService.updateData(sid);
        modelAndView.addObject("student",student);
        return modelAndView;
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        studentService.delete(id);
        return "redirect:/student/student";
    }
}