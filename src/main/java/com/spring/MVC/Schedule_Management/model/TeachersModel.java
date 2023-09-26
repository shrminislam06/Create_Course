package com.spring.MVC.Schedule_Management.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TeachersModel {

    private String teacherName;
    private String teacherAcro;
    private String teacherID;
    private String teacherPhone;
    private String teacherPosition;
    private String teacherEmail;
    private String confirmPassword;

}
