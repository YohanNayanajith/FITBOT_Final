package com.group39.fitbot.group39_fitbot.model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class ManagerMarkMemberAttendence {
    private String member_id;
    private LocalDate date;
    private LocalTime start_time;
    private int status;

    public ManagerMarkMemberAttendence(String memberId, LocalDate currentDate, LocalTime currentTime) {
    }

    public ManagerMarkMemberAttendence(String member_id, LocalDate date, LocalTime start_time, int status) {
        this.member_id = member_id;
        this.date = date;
        this.start_time = start_time;
        this.status = status;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalTime start_time) {
        this.start_time = start_time;
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
                "member_id='" + member_id + '\'' +
                ", date=" + date +
                ", start_time=" + start_time +
                ", status=" + status +
                '}';
    }
}



