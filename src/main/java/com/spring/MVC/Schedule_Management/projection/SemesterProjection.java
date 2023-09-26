package com.spring.MVC.Schedule_Management.projection;

public interface SemesterProjection {

    Long getSemesterId();
    String getSemesterName();
    Integer getYear();
    String getCourseCode();

    String getCourseName();

}
