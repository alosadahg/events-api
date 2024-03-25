package com.example.api.model.event;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.time.LocalDate;

public interface EventRepository extends JpaRepository<Event,Integer> {
    List<Event> findByOrganizer(Integer organizer);
    List<Event> findByLocation(String location);
    List<Event> findByStartdate(LocalDate startdate);
    List<Event> findByStatus(String status);
}
