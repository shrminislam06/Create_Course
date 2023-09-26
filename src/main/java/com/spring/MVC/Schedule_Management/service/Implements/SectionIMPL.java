package com.spring.MVC.Schedule_Management.service.Implements;


import com.spring.MVC.Schedule_Management.Entity.Section;
import com.spring.MVC.Schedule_Management.repository.SectionRepo;
import com.spring.MVC.Schedule_Management.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionIMPL implements SectionService {
    @Autowired
    private SectionRepo sectionRepo;


    @Override
    public List<Section> ListAll() {
        return sectionRepo.findAll();
    }

    @Override
    public void savedata(Section section) {
        sectionRepo.save(section);
    }

    @Override
    public Section updateData(long sectionId) {
        return sectionRepo.findById(sectionId).get();
    }

    @Override
    public void delete(Long sectionId) {
sectionRepo.deleteById(sectionId);
    }
}
