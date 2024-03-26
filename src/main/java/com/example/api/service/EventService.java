package com.example.api.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.api.model.attendevent.AttendEvent;
import com.example.api.model.attendevent.AttendEventRepository;
import com.example.api.model.event.Event;
import com.example.api.model.event.EventRepository;

@Service
public class EventService {
    
    @Autowired
    private EventRepository eventRepo;

    @Autowired
    private AttendEventRepository attendEventRepo;

    public List<Event> getAllEvents() {
        List<Event> events = eventRepo.findAll();
        return events.stream()
                .sorted(Comparator.comparingInt((Event event) -> getEventStatusOrder(event.getStatus()))
                        .thenComparing(Event::getStartdate))
                .collect(Collectors.toList());
    }

    private int getEventStatusOrder(String status) {
		switch (status) {
			case "ongoing":
				return 0;
			case "upcoming":
				return 1;
			case "cancelled":
				return 2;
			case "finished":
				return 3;
			default:
				return -1;
		}
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
                List<AttendEvent> attendEventList = attendEventRepo.findByEventid(eid);
                for (AttendEvent attendEvent : attendEventList) {
                    attendEvent.setIsread(0);
                    attendEventRepo.save(attendEvent);
                }
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

    public int updateEvent(Event e) {
        if(e!=null) {
            Event event = eventRepo.findById(e.getEid().intValue()).get();
            event.setEventname(e.getEventname());
            event.setDescription(e.getDescription());
            event.setEnddate(e.getEnddate());
            event.setStartdate(e.getStartdate());
            event.setLocation(e.getLocation());
            event.setStatus(e.getStatus());
            eventRepo.save(event);
            return 1;
        }
        return 0;
    }

    public List<Event> getByOrganizer(Integer organizer) {
        return eventRepo.findByOrganizer(organizer, Sort.by(Direction.DESC, "startdate"));
    }

    public int deleteEvent(Integer eventid){
        if(eventid!=null){
        if(eventRepo.existsById(eventid)) {
            eventRepo.deleteById(eventid);
            return 1;
        }
    }
        return 0;
    }
}