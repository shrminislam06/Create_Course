package com.spring.MVC.Schedule_Management.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import java.util.Set;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long semesterId;
    private String semesterName;
    private int year;

    @ManyToMany
    private Set<Course> courses;
}
