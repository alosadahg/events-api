package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.attendevent.AttendEvent;
import com.example.demo.model.attendevent.AttendEventRepository;

@Service
public class AttendEventService {

    @Autowired
    private AttendEventRepository attendeventrepo;

    public List<AttendEvent> getAll() {
        return attendeventrepo.findAll();
    }

    public String addToPending(Integer userid, Integer eventid) {
        if(attendeventrepo.findByEventidAndUserid(eventid, userid).isEmpty()) {
            AttendEvent newRecord = new AttendEvent(eventid, userid, "interested");
            attendeventrepo.save(newRecord);
            return newRecord.toString();
        }
        return "Transaction failed. User has existing record.";
    }

    public String addToApproved(Integer userid, Integer eventid) {
        if(!attendeventrepo.findByEventidAndUserid(eventid, userid).isEmpty()) {
            AttendEvent record = attendeventrepo.findByEventidAndUserid(eventid, userid).get(0);
            record.setStatus("approved");
            attendeventrepo.save(record);
            return record.toString();
        }
        return "Transaction failed. User has no record.";
    }

    
}
