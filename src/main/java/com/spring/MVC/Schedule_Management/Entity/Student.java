package com.spring.MVC.Schedule_Management.Entity;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sid;
    private String studentId;
    private String studentName;
    private String studentPhone;
    private String studentEmail;
    private String dept;

}

