package com.example.demo.model.attendevent;

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
    public AttendEvent() {
    }
    public AttendEvent(Integer eventid, Integer userid, String status) {
        this.eventid = eventid;
        this.userid = userid;
        this.status = status;
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
        return "AttendEvent [id=" + id + ", eventid=" + eventid + ", userid=" + userid + ", status=" + status + "]";
    }
}
