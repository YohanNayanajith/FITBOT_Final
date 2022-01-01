package com.group39.fitbot.group39_fitbot.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Notification {
    private int notification_id;
    private String user_id;
    private String notification_title;
    private LocalTime notification_time;
    private LocalDate notification_date;
    private String notification_type;
    private int notification_status;

    public Notification() {
    }

    public Notification(int notification_id, String user_id, String notification_title, LocalTime notification_time, LocalDate notification_date, String notification_type, int notification_status) {
        this.notification_id = notification_id;
        this.user_id = user_id;
        this.notification_title = notification_title;
        this.notification_time = notification_time;
        this.notification_date = notification_date;
        this.notification_type = notification_type;
        this.notification_status = notification_status;
    }

    public int getNotification_id() {
        return notification_id;
    }

    public void setNotification_id(int notification_id) {
        this.notification_id = notification_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getNotification_title() {
        return notification_title;
    }

    public void setNotification_title(String notification_title) {
        this.notification_title = notification_title;
    }

    public LocalTime getNotification_time() {
        return notification_time;
    }

    public void setNotification_time(LocalTime notification_time) {
        this.notification_time = notification_time;
    }

    public LocalDate getNotification_date() {
        return notification_date;
    }

    public void setNotification_date(LocalDate notification_date) {
        this.notification_date = notification_date;
    }

    public String getNotification_type() {
        return notification_type;
    }

    public void setNotification_type(String notification_type) {
        this.notification_type = notification_type;
    }

    public int getNotification_status() {
        return notification_status;
    }

    public void setNotification_status(int notification_status) {
        this.notification_status = notification_status;
    }
}
