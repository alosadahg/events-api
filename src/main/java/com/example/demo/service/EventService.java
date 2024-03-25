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
            return e.toString();
        }
        return "Transaction failed";
    }

    public String cancel(Integer eid, String status) {
        if(eid!=null) {
            List<Event> eList = eventRepo.findByEid(eid);
            if(!eList.isEmpty()) {
                Event event = eList.get(0);
                event.setStatus(status);
                eventRepo.save(event);
                return event.toString();
            }
            return "No event record found";
        }
        return "Transaction failed";
    }

    public String updateThumbnail(Integer eid, String thumbnail) {
        if(eid!=null) {
            List<Event> eList = eventRepo.findByEid(eid);
            if(!eList.isEmpty()) {
                Event event = eList.get(0);
                event.setThumbnail(thumbnail);
                eventRepo.save(event);
                return event.toString();
            }
            return "No event record found";
        }
        return "Transaction failed";
    }
}
