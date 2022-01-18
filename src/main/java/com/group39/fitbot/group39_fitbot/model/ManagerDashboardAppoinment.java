package com.group39.fitbot.group39_fitbot.model;

import java.sql.Time;

public class ManagerDashboardAppoinment {
    private String mem_firstname;
    private Time appoin_starttime;

    public ManagerDashboardAppoinment(String mem_firstname, Time appoin_starttime) {
        this.mem_firstname = mem_firstname;
        this.appoin_starttime = appoin_starttime;
    }

    public String getMem_firstname() {
        return mem_firstname;
    }

    public void setMem_firstname(String mem_firstname) {
        this.mem_firstname = mem_firstname;
    }

    public Time getAppoin_starttime() {
        return appoin_starttime;
    }

    public void setAppoin_starttime(Time appoin_starttime) {
        this.appoin_starttime = appoin_starttime;
    }

    @Override
    public String toString() {
        return "ManagerDashboardAppoinment{" +
                "mem_firstname='" + mem_firstname + '\'' +
                ", appoin_starttime=" + appoin_starttime +
                '}';
    }
}
