package com.spring.MVC.Schedule_Management.model;

public class CourseTeacherModel {

    private Long Id;
    private String teacherAcro;
    private String courseCode;
    private String courseName;
    private String semesterName;
    private String sectionName;

    public CourseTeacherModel() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTeacherAcro() {
        return teacherAcro;
    }

    public void setTeacherAcro(String teacherAcro) {
        this.teacherAcro = teacherAcro;
    }


    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    @Override
    public String toString() {
        return "CourseTeacherModel{" +
                "Id=" + Id +
                ", teacherAcro='" + teacherAcro + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                ", semesterName='" + semesterName + '\'' +
                ", sectionName='" + sectionName + '\'' +
                '}';
    }
}
