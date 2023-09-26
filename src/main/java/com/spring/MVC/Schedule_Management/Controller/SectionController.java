package com.spring.MVC.Schedule_Management.Controller;

import com.spring.MVC.Schedule_Management.Entity.Section;
import com.spring.MVC.Schedule_Management.service.SectionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/section")
public class SectionController {

    private SectionService sectionService;

    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @GetMapping("/section")
    public String homepage(Model model){
        List<Section> sectionList=sectionService.ListAll();
        model.addAttribute("sectionList",sectionList);
        return "section";
    }

    @RequestMapping("/addSection")
    public String addsection(Model model){
        List<Section>sectionList=sectionService.ListAll();
        model.addAttribute("sectionList",sectionList);
        model.addAttribute("section",new Section());
        return "addSection";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String savedata(@ModelAttribute("section")Section section, HttpSession session){
        sectionService.savedata(section);
        session.setAttribute("Added successfully",section);
        return "redirect:section";
    }

    @RequestMapping("/edit/{sectionId}")
    public ModelAndView updatedata(@PathVariable("sectionId") long sectionId){
        ModelAndView modelAndView=new ModelAndView("addSection" );
        Section section=sectionService.updateData(sectionId);
        modelAndView.addObject("section",section);
        return modelAndView;
    }

    @RequestMapping("/delete/{sectionId}")
    public String delete(@PathVariable("sectionId")Long sectionId){
        sectionService.delete(sectionId);
        return "section";
    }
}
