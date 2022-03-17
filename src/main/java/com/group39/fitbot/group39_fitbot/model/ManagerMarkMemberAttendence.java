package com.group39.fitbot.group39_fitbot.model;

import java.sql.Date;
import java.sql.Time;

public class ManagerMarkMemberAttendence {
    private Date date;
    private Time start_time;
    private String member_id;
    private int status;

    public ManagerMarkMemberAttendence(Date date, Time start_time, String member_id, int status) {
        this.date = date;
        this.start_time = start_time;
        this.member_id = member_id;
        this.status = status;
    }

    public ManagerMarkMemberAttendence() {

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStart_time() {
        return start_time;
    }

    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "ManagerMarkMemberAttendence{" +
                "date=" + date +
                ", start_time=" + start_time +
                ", member_id='" + member_id + '\'' +
                ", status=" + status +
                '}';
    }
}



