package com.spring.MVC.Schedule_Management.repository;

import com.spring.MVC.Schedule_Management.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepo extends JpaRepository<Room,Long> {
}
