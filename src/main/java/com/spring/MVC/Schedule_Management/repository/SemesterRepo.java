package com.spring.MVC.Schedule_Management.repository;

import com.spring.MVC.Schedule_Management.Entity.Semester;
import com.spring.MVC.Schedule_Management.projection.SemesterProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface SemesterRepo extends JpaRepository<Semester,Long> {

   @Query(value="SELECT s.semester_id semesterId,\n" +
           "s.semester_name semesterName,\n" +
           "s.year year,\n" +
           " c.course_code courseCode,\n" +
           " c.course_name courseName\n" +
           " from semester s \n" +
           " inner join semester_courses sc on (s.semester_id = sc.semester_semester_id)\n" +
           " INNER  JOIN course c ON sc.courses_id=c.id",
           nativeQuery=true)
    List<SemesterProjection> findSchedule();
    Set<Semester> findAllBySemesterIdIn(Set<Long> semesterIds);

    ;


}
