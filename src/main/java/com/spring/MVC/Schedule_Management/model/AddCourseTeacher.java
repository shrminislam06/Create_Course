package com.spring.MVC.Schedule_Management.model;

import lombok.Data;

import java.util.Set;

@Data
public class AddCourseTeacher {
    private Long Id;
    Set<Long> courseIds;
    Long teachersIds;
    Long semesterIds;
    Long sectionIds;
}
