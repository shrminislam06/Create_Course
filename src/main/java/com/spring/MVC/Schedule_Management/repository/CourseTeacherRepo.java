package com.spring.MVC.Schedule_Management.repository;

import com.spring.MVC.Schedule_Management.Entity.EnrolledTeacher;
import com.spring.MVC.Schedule_Management.Entity.Semester;
import com.spring.MVC.Schedule_Management.Entity.Teachers;
import com.spring.MVC.Schedule_Management.projection.EnrolledTeacherProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CourseTeacherRepo extends JpaRepository<EnrolledTeacher, Long> {

    List<EnrolledTeacher> getByTeachersAndSemesters(Teachers teachers, Semester semester);

    @Query(value = "select enrl.id Id,\n" +
            "t.teacher_acro teacherAcro,\n" +
            "c.course_code courseCode,\n" +
            "c.course_name courseName,\n" +
            "s.semester_name semesterName,\n" +
            "se.section_name sectionName\n" +
            "from enrolled_teacher enrl inner join teachers t  on enrl.teachers_id=t.id " +
            "inner join course c on enrl.courses_id=c.id " +
            "inner join semester s on enrl.semesters_semester_id=s.semester_id " +
            "inner join section se on enrl.sections_section_id=se.section_id", nativeQuery = true)
    List<EnrolledTeacherProjection> enrolledTeacher();

    List<EnrolledTeacher> getByTeachers(Teachers teachers);

}
