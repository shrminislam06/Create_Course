package com.spring.MVC.Schedule_Management.Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Teachers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String teacherName;
    private String teacherAcro;
    private String teacherID;
    private String teacherPhone;
    private String teacherEmail;
    private String teacherPosition;



}