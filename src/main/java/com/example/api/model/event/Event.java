package com.example.api.model.event;

import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import jakarta.persistence.*;

@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eid;
    private String eventname;
    private Integer organizer;
    private String description;
    private String location;
    private LocalDate startdate;
    private LocalDate enddate;
    private Integer upvotes;
    private Integer[] participants;
    private Integer[] reviews;
    private String status;
    private String thumbnail;

    public Event() {
    }

    public Event(String eventname, Integer organizer, String description, String location, LocalDate startdate,
            LocalDate enddate, String status, String thumbnail) {
        this.eventname = eventname;
        this.organizer = organizer;
        this.description = description;
        this.location = location;
        this.startdate = startdate;
        this.enddate = enddate;
        setUpvotes(0);
        setParticipants(new Integer[0]);
        setReviews(new Integer[0]);
        this.status = status;
        this.thumbnail = thumbnail;
    }

    public Event(Integer eid, String eventname, String description, String location,
            LocalDate startdate, LocalDate enddate, String status, String thumbnail) {
        this.eid = eid;
        this.eventname = eventname;
        this.description = description;
        this.location = location;
        this.startdate = startdate;
        this.enddate = enddate;
        this.status = status;
        this.thumbnail = thumbnail;
    }

    public Event(Integer eid, String eventname, String description, String location,
            LocalDate startdate, LocalDate enddate, String status) {
        this.eid = eid;
        this.eventname = eventname;
        this.description = description;
        this.location = location;
        this.startdate = startdate;
        this.enddate = enddate;
        this.status = status;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public Integer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Integer organizer) {
        this.organizer = organizer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getStartdate() {
        return startdate;
    }

    public void setStartdate(LocalDate startdate) {
        this.startdate = startdate;
    }

    public LocalDate getEnddate() {
        return enddate;
    }

    public void setEnddate(LocalDate enddate) {
        this.enddate = enddate;
    }

    public Integer getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(Integer upvotes) {
        this.upvotes = upvotes;
    }

    public Integer[] getParticipants() {
        return participants;
    }

    public void setParticipants(Integer[] participants) {
        this.participants = participants;
    }

    public Integer[] getReviews() {
        return reviews;
    }

    public void setReviews(Integer[] reviews) {
        this.reviews = reviews;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            if(upvotes == null) {
                upvotes = 0;
            }
            if (participants == null) {
                participants = new Integer[0];
            }
            if (reviews == null) {
                reviews = new Integer[0];
            }
            if (thumbnail == null) {
                thumbnail = "";
            }
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "transaction failed";
        }
    }

}
