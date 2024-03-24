package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.event.Event;
import com.example.demo.service.EventService;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping(path="/event")
public class EventController {

    @Autowired
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/view-all")
	public List<Event> getUsers() {
		return eventService.getAllEvents();
	}

    @PostMapping("/add")
    public String addEvent(Event event) {
        return eventService.add(event);
    }
    
}
