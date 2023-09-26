package com.spring.MVC.Schedule_Management.model;

public class UpdateSemesterModel extends AddSemesterModel {
    private Long semesterId;

    public Long getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Long semesterId) {
        this.semesterId = semesterId;
    }
}
