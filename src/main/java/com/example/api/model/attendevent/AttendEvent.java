package com.example.api.model.attendevent;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.*;

@Entity
@Table(name = "attendevent")
public class AttendEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer eventid;
    private Integer userid;
    private String status;
    private Integer isread;
    private Integer isreadbyorganizer;
    public AttendEvent() {
    }
    public AttendEvent(Integer eventid, Integer userid, String status) {
        this.eventid = eventid;
        this.userid = userid;
        this.status = status;
        this.isread = 0;
        this.isreadbyorganizer = 0;
    }

    public AttendEvent(Integer eventid, Integer userid, String status, Integer isread) {
        this.eventid = eventid;
        this.userid = userid;
        this.status = status;
        this.isread = isread;
        this.isreadbyorganizer = 0;
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getEventid() {
        return eventid;
    }
    public void setEventid(Integer eventid) {
        this.eventid = eventid;
    }
    public Integer getUserid() {
        return userid;
    }
    public void setUserid(Integer userid) {
        this.userid = userid;
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
    public Integer getIsread() {
        return isread;
    }
    public void setIsread(Integer isread) {
        this.isread = isread;
    }
	public Integer getIsreadbyorganizer() {
		return isreadbyorganizer;
	}
	public void setIsreadbyorganizer(Integer isreadbyorganizer) {
		this.isreadbyorganizer = isreadbyorganizer;
	}
}
