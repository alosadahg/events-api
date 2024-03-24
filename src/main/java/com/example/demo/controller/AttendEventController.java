package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.attendevent.AttendEvent;
import com.example.demo.service.AttendEventService;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/attend-event")
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

    @PostMapping("/add")
    public String add(AttendEvent data) {
        return attendEventService.add(data);
    }
    
}