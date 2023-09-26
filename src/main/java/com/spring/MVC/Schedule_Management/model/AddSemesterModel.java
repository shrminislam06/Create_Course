package com.spring.MVC.Schedule_Management.model;

import java.util.List;
import java.util.Set;

public class AddSemesterModel {

    private Long semesterId;

    private String semesterName;
    private int year;
    private Set<Long> courseIds;

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Set<Long> getCourseIds() {
        return courseIds;
    }


    public Long getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Long semesterId) {
        this.semesterId = semesterId;
    }

    public void setCourseIds(Set<Long> courseIds) {
        this.courseIds = courseIds;
    }
}
