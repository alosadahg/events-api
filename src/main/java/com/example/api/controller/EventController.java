package com.example.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.model.event.Event;
import com.example.api.service.EventService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
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
    public String addEvent(@Payload Event event) {
        String result = eventService.add(event);
        return result;
    }
    
    @PutMapping("/update-status")
    public String updateStatus(Integer eventid, String status) {
        return eventService.updateStatus(eventid, status);
    }

    @PutMapping("/update-thumbnail")
    public String updateThumbnail(Integer eventid, String thumbnail) {
        return eventService.updateThumbnail(eventid, thumbnail);
    }

    @PutMapping("/upvote")
    public String upvote(Integer eventid) {
        return eventService.upvote(eventid);
    }
}
