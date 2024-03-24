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

    public String add(AttendEvent data) {
        if(attendeventrepo.findByEventidAndUserid(data.getEventid(), data.getUserid()).isEmpty()) {
            if(data != null) {
                attendeventrepo.save(data);
                return "User " + data.getUserid()+ " added record with event " + data.getEventid();
            }
        }
        return "User " + data.getUserid() + " has existing record in event " + data.getEventid();
    }

}
