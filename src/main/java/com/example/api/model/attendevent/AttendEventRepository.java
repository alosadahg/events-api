package com.example.api.model.attendevent;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendEventRepository extends JpaRepository<AttendEvent, Integer>{
    List<AttendEvent> findByEventid(Integer eventid);
    List<AttendEvent> findByUserid(Integer userid);
    List<AttendEvent> findByUserid(Integer userid, Sort s);
    List<AttendEvent> findByUseridAndStatusNot(Integer userid, String status);
    List<AttendEvent> findByStatus(String status);
    List<AttendEvent> findByEventidAndUserid(Integer eventid, Integer userid);
    List<AttendEvent> findByEventidAndUseridAndStatus(Integer eventid, Integer userid, String status);
}
