package com.example.demo.model.event;

import java.time.LocalDate;
import java.util.Arrays;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    public Event() {
    }
    public Event(String eventname, Integer organizer, String description, String location, LocalDate startdate,
            LocalDate enddate, String status) {
        this.eventname = eventname;
        this.organizer = organizer;
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
    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace(); 
            return "transaction failed";
        }
    }
}
