package com.group39.fitbot.group39_fitbot.model;

import java.sql.Date;
import java.sql.Time;

public class ManagerViewInquiry {
    private String first_name;
    private int inquiry_id;
    private Date inquiry_date;
    private Time inquiry_time;
    private String inquiry_title;
    private String status;
    private String description;

    public ManagerViewInquiry(){

    }

    public ManagerViewInquiry(String first_name, int inquiry_id, Date inquiry_date, Time inquiry_time, String inquiry_title, String status, String description) {
        this.first_name = first_name;
        this.inquiry_id = inquiry_id;
        this.inquiry_date = inquiry_date;
        this.inquiry_time = inquiry_time;
        this.inquiry_title = inquiry_title;
        this.status = status;
        this.description = description;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public int getInquiry_id() {
        return inquiry_id;
    }

    public void setInquiry_id(int inquiry_id) {
        this.inquiry_id = inquiry_id;
    }

    public Date getInquiry_date() {
        return inquiry_date;
    }

    public void setInquiry_date(Date inquiry_date) {
        this.inquiry_date = inquiry_date;
    }

    public Time getInquiry_time() {
        return inquiry_time;
    }

    public void setInquiry_time(Time inquiry_time) {
        this.inquiry_time = inquiry_time;
    }

    public String getInquiry_title() {
        return inquiry_title;
    }

    public void setInquiry_title(String inquiry_title) {
        this.inquiry_title = inquiry_title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "ManagerViewInquiry{" +
                "first_name='" + first_name + '\'' +
                ", inquiry_id=" + inquiry_id +
                ", inquiry_date=" + inquiry_date +
                ", inquiry_time=" + inquiry_time +
                ", inquiry_title='" + inquiry_title + '\'' +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

