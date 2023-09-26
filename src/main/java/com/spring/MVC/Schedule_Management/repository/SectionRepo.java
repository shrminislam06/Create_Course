package com.spring.MVC.Schedule_Management.repository;


import com.spring.MVC.Schedule_Management.Entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepo extends JpaRepository<Section,Long> {
}
