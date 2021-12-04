package com.group39.fitbot.group39_fitbot.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class PhysicalAppointment {
    private LocalDate appointment_date;
    private LocalTime start_time;
    private LocalTime finish_time;
    private String equipment;
    private String member_id;

    public PhysicalAppointment() {
    }

    public PhysicalAppointment(LocalDate appointment_date,LocalTime start_time, LocalTime finish_time, String equipment, String member_id) {
        this.appointment_date = appointment_date;
        this.start_time = start_time;
        this.finish_time = finish_time;
        this.equipment = equipment;
        this.member_id = member_id;
    }

    public LocalTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalTime start_time) {
        this.start_time = start_time;
    }

    public LocalTime getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(LocalTime finish_time) {
        this.finish_time = finish_time;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public LocalDate getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(LocalDate appointment_date) {
        this.appointment_date = appointment_date;
    }
}
