package com.spring.MVC.Schedule_Management.service;


import com.spring.MVC.Schedule_Management.Entity.Section;

import java.util.List;

public interface SectionService {
    List<Section> ListAll();

    void savedata(Section section);

    Section updateData(long sectionId);

    void delete(Long sectionId);
}
