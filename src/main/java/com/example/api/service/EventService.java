package com.example.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.model.event.Event;
import com.example.api.model.event.EventRepository;

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

    public String updateStatus(Integer eid, String status) {
        if(eid!=null) {
            Event event = eventRepo.findById(eid).get();
            if(event!=null) {
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
            Event event = eventRepo.findById(eid).get();
            if(event!=null) {
                event.setThumbnail(thumbnail);
                eventRepo.save(event);
                return event.toString();
            }
            return "No event record found";
        }
        return "Transaction failed";
    }

    public String upvote(Integer eid) {
        if(eid!=null) {
            Event event = eventRepo.findById(eid).get();
            if(event!=null) {
                if(event.getUpvotes()==null) {
                    event.setUpvotes(0);
                }
                int upCount = event.getUpvotes();
                upCount++;
                event.setUpvotes(upCount);
                eventRepo.save(event);
                return event.toString();
            }
            return "No event record found";
        }
        return "Transaction failed";
    }
}
