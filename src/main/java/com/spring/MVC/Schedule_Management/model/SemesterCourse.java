package com.spring.MVC.Schedule_Management.model;

import lombok.*;


public class SemesterCourse {

    private long semesterId;
    private String semesterName;
    private  int year;
    private String courseCode;
    private String courseName;


    public long getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(long semesterId) {
        this.semesterId = semesterId;
    }

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

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "SemesterCourse{" +
                "semesterId=" + semesterId +
                ", semesterName='" + semesterName + '\'' +
                ", year=" + year +
                ", courseCode='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
