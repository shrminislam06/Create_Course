package com.spring.MVC.Schedule_Management.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StudentRegistrationModel {


private long id;
    private String studentId;
    private String studentName;
    private String semester;
    private String section;
    private String program;
    private String email;
    private String password;
}
