package com.example.api.model.review;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rid;
    private Integer userid;
    private Integer eventid;
    private String reviewtext;
    public Review() {
    }
    public Review(Integer userid, Integer eventid, String reviewtext) {
        this.userid = userid;
        this.eventid = eventid;
        this.reviewtext = reviewtext;
    }
    public Integer getRid() {
        return rid;
    }
    public void setRid(Integer rid) {
        this.rid = rid;
    }
    public Integer getUserid() {
        return userid;
    }
    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    public Integer getEventid() {
        return eventid;
    }
    public void setEventid(Integer eventid) {
        this.eventid = eventid;
    }
    public String getReview() {
        return reviewtext;
    }
    public void setReview(String review) {
        this.reviewtext = review;
    }
    @Override
    public String toString() {
       ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace(); 
            return "transaction failed";
        }
    }
    
    
}
