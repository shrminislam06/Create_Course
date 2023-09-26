package com.spring.MVC.Schedule_Management.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class EnrolledTeacher {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @ManyToOne
    Teachers teachers;

    @ManyToOne
    Semester semesters;

    @ManyToOne
    private Course courses;
    @ManyToOne
    private Section sections;


}