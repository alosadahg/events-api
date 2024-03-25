package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.event.Event;
import com.example.demo.service.EventService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(path="/event")
@CrossOrigin
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
    
    @PutMapping("/update-status")
    public String updateStatus(Integer eventid, String status) {
        return eventService.cancel(eventid, status);
    }

    @PutMapping("/update-thumbnail")
    public String updateThumbnail(Integer eventid, String thumbnail) {
        return eventService.updateThumbnail(eventid, thumbnail);
    }
}
