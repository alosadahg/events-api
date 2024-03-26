package com.example.api.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.api.model.attendevent.AttendEvent;
import com.example.api.model.attendevent.AttendEventRepository;
import com.example.api.model.event.Event;
import com.example.api.model.event.EventRepository;

@Service
public class AttendEventService {

    @Autowired
    private AttendEventRepository attendeventrepo;

    @Autowired
    private EventRepository eventRepo;

    @Autowired
    private EventService eventService;

    public List<AttendEvent> getAll() {
        return attendeventrepo.findAll();
    }

    public List<AttendEvent> getByUser(Integer userid) {
        Sort sort = Sort.by(Sort.Direction.ASC, "isread");
        return attendeventrepo.findByUserid(userid, sort);
    }

    public List<AttendEvent> getByOrganizer(Integer eventid) {
        List<Event> eventlist = eventService.getByOrganizer(eventid);
        List<AttendEvent> attendeesList = new ArrayList<AttendEvent>();
        for (Event event : eventlist) {
            attendeesList.addAll(attendeventrepo.findByEventid(event.getEid()));
        }
        return attendeesList;
    }

    public String addToPending(Integer userid, Integer eventid) {
        if (attendeventrepo.findByEventidAndUseridAndStatus(eventid, userid, "interested").isEmpty()) {
            AttendEvent newRecord = new AttendEvent(eventid, userid, "interested");
            attendeventrepo.save(newRecord);
            setIsRead(userid.intValue(), eventid.intValue(), "pending", 0);
            return newRecord.toString();
        }
        return "Transaction failed. Already has existing record.";
    }

    public String addToApproved(Integer userid, Integer eventid) {
        if (!attendeventrepo.findByEventidAndUserid(eventid, userid).isEmpty()) {
            AttendEvent record = attendeventrepo.findByEventidAndUserid(eventid, userid).get(0);
            record.setStatus("approved");
            record.setIsread(0);
            attendeventrepo.save(record);
            if (eventid != null) {
                Event e = eventRepo.findById(eventid).get();
                if (e.getParticipants() == null) {
                    e.setParticipants(new Integer[0]);
                }
                Integer[] participants = e.getParticipants();
                Integer[] updatedParticipants = Arrays.copyOf(participants, participants.length + 1);
                updatedParticipants[participants.length] = userid;
                e.setParticipants(updatedParticipants);
                eventRepo.save(e);
                setIsRead(userid.intValue(), eventid.intValue(), "approved", 0);
            }
            return record.toString();
        }
        return "Transaction failed. No record found.";
    }

    public int cancelAttendInterest(Integer userid, Integer eventid) {
        AttendEvent record = attendeventrepo.findByEventidAndUserid(eventid, userid).get(0);
        if (record != null) {
            record.setStatus("cancelled");
            record.setIsread(0);
            attendeventrepo.save(record);
            Event event = eventRepo.findById(eventid.intValue()).get();
            Integer[] participants = event.getParticipants();
            List<Integer> updatedParticipants = new ArrayList<>();
            for (Integer participant : participants) {
                if (!participant.equals(userid.intValue())) {
                    updatedParticipants.add(participant);
                }
            }
            event.setParticipants(updatedParticipants.toArray(new Integer[0]));
            eventRepo.save(event);
            return 1;
        }
        return 0;
    }

    public int setIsRead(int userid, int eventid, String status, int isread) {
        AttendEvent record = attendeventrepo.findByEventidAndUseridAndStatus(eventid, userid, status).get(0);
        if (record != null) {
            record.setIsread(isread);
            attendeventrepo.save(record);
            return 1;
        }
        return 0;
    }

    public int setIsReadByOrganizer(int id, int isread) {
        AttendEvent record = attendeventrepo.findById(id).get();
        if (record != null) {
            record.setIsread(isread);
            attendeventrepo.save(record);
            return 1;
        }
        return 0;
    }
}
