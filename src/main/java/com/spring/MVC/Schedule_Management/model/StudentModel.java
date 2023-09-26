package com.spring.MVC.Schedule_Management.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentModel {
    private String studentId;
    private String studentName;
    private String studentPhone;
    private String dept;
    private String studentEmail;
    private String passworrd;
    private String confirmPassworrd;

}
