package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.event.Event;
import com.example.demo.model.event.EventRepository;

@Service
public class EventService {
    
    @Autowired
    private EventRepository eventRepo;

    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }

    public String add(Event e) {
        if(e!=null) {
            eventRepo.save(e);
            return "Event added successfully";
        }
        return "Incomplete event details";
    }
}
