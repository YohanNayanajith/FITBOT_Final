package com.group39.fitbot.group39_fitbot.model;

import java.sql.Time;
import java.util.Date;

public class InsLeave {

    private String instructor_id;
    private Date request_date;
    private String branch_id;
    private String leave_reason;
    private Date leave_form_date;
    private Time leave_form_time;
    private Date leave_to_date;
    private Time leave_to_time;

    public InsLeave() {
    }

    public InsLeave(String instructor_id, Date request_date, String branch_id, String leave_reason, Date leave_form_date, Time leave_form_time, Date leave_to_date, Time leave_to_time) {
        this.instructor_id = instructor_id;
        this.request_date = request_date;
        this.branch_id = branch_id;
        this.leave_reason = leave_reason;
        this.leave_form_date = leave_form_date;
        this.leave_form_time = leave_form_time;
        this.leave_to_date = leave_to_date;
        this.leave_to_time = leave_to_time;
    }

    public String getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(String instructor_id) {
        this.instructor_id = instructor_id;
    }

    public Date getRequest_date() {
        return request_date;
    }

    public void setRequest_date(Date request_date) {
        this.request_date = request_date;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    public String getLeave_reason() {
        return leave_reason;
    }

    public void setLeave_reason(String leave_reason) {
        this.leave_reason = leave_reason;
    }

    public Date getLeave_form_date() {
        return leave_form_date;
    }

    public void setLeave_form_date(Date leave_form_date) {
        this.leave_form_date = leave_form_date;
    }

    public Time getLeave_form_time() {
        return leave_form_time;
    }

    public void setLeave_form_time(Time leave_form_time) {
        this.leave_form_time = leave_form_time;
    }

    public Date getLeave_to_date() {
        return leave_to_date;
    }

    public void setLeave_to_date(Date leave_to_date) {
        this.leave_to_date = leave_to_date;
    }

    public Time getLeave_to_time() {
        return leave_to_time;
    }

    public void setLeave_to_time(Time leave_to_time) {
        this.leave_to_time = leave_to_time;
    }

    @Override
    public String toString() {
        return "InsLeave{" +
                "instructor_id='" + instructor_id + '\'' +
                ", request_date=" + request_date +
                ", branch_id='" + branch_id + '\'' +
                ", leave_reason='" + leave_reason + '\'' +
                ", leave_form_date=" + leave_form_date +
                ", leave_form_time=" + leave_form_time +
                ", leave_to_date=" + leave_to_date +
                ", leave_to_time=" + leave_to_time +
                '}';
    }
}
