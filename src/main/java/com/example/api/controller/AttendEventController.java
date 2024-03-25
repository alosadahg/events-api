package com.example.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.model.attendevent.AttendEvent;
import com.example.api.service.AttendEventService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/attend-event")
@CrossOrigin
public class AttendEventController {

    @Autowired
    private AttendEventService attendEventService;

    public AttendEventController(AttendEventService attendEventService) {
        this.attendEventService = attendEventService;
    }

    @GetMapping("/view-all")
    public List<AttendEvent> getAll() {
        return attendEventService.getAll();
    }

    @PostMapping("/view-by-user")
    public List<AttendEvent> getByUser(Integer userid) {
        return attendEventService.getByUser(userid);
    }

    @PostMapping("/interested")
    public String setPending(Integer userid, Integer eventid) {
        return attendEventService.addToPending(userid, eventid);
    }

    @PutMapping("/approved")
    public String setApproved(Integer userid, Integer eventid) {
        return attendEventService.addToApproved(userid, eventid);
    }
    
}