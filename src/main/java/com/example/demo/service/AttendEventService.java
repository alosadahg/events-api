package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.attendevent.AttendEvent;
import com.example.demo.model.attendevent.AttendEventRepository;
import com.example.demo.model.event.Event;
import com.example.demo.model.event.EventRepository;

@Service
public class AttendEventService {

    @Autowired
    private AttendEventRepository attendeventrepo;

    @Autowired
    private EventRepository eventRepo;

    public List<AttendEvent> getAll() {
        return attendeventrepo.findAll();
    }

    public List<AttendEvent> getByUser(Integer userid) {
        return attendeventrepo.findByUserid(userid);
    }

    public String addToPending(Integer userid, Integer eventid) {
        if (attendeventrepo.findByEventidAndUserid(eventid, userid).isEmpty()) {
            AttendEvent newRecord = new AttendEvent(eventid, userid, "interested");
            attendeventrepo.save(newRecord);
            return newRecord.toString();
        }
        return "Transaction failed. Already has existing record.";
    }

    public String addToApproved(Integer userid, Integer eventid) {
        if (!attendeventrepo.findByEventidAndUserid(eventid, userid).isEmpty()) {
            AttendEvent record = attendeventrepo.findByEventidAndUserid(eventid, userid).get(0);
            record.setStatus("approved");
            attendeventrepo.save(record);
            if (eventid != null) {
                Event e = eventRepo.findById(eventid).get();
                if(e.getParticipants()==null) {
                    e.setParticipants(new Integer[0]);
                }
                Integer[] participants = e.getParticipants();
                Integer[] updatedParticipants = Arrays.copyOf(participants, participants.length + 1);
                updatedParticipants[participants.length] = userid;
                e.setParticipants(updatedParticipants);
                eventRepo.save(e);
            }
            return record.toString();
        }
        return "Transaction failed. No record found.";
    }

}
