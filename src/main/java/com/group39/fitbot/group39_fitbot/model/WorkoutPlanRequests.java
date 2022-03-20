package com.group39.fitbot.group39_fitbot.model;

import java.time.LocalDate;

public class WorkoutPlanRequests {
    private String instructor_id;
    private int has_assign;
    private LocalDate request_date;
    private String member_id;

    public WorkoutPlanRequests() {
    }

    public WorkoutPlanRequests(String instructor_id, int has_assign, LocalDate request_date, String member_id) {
        this.instructor_id = instructor_id;
        this.has_assign = has_assign;
        this.request_date = request_date;
        this.member_id = member_id;
    }

    public String getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(String instructor_id) {
        this.instructor_id = instructor_id;
    }

    public int getHas_assign() {
        return has_assign;
    }

    public void setHas_assign(int has_assign) {
        this.has_assign = has_assign;
    }

    public LocalDate getRequest_date() {
        return request_date;
    }

    public void setRequest_date(LocalDate request_date) {
        this.request_date = request_date;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }
}
