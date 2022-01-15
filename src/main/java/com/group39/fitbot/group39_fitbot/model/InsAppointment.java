package com.group39.fitbot.group39_fitbot.model;

import java.sql.Time;
import java.util.Date;

public class InsAppointment {
  private String name;
  private Date appointment_date;
  private Time start_time;
  private Time finish_time;

  public InsAppointment() {
  }

  public InsAppointment(String name, Date appointment_date, Time start_time, Time finish_time) {
    this.name = name;
    this.appointment_date = appointment_date;
    this.start_time = start_time;
    this.finish_time = finish_time;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getAppointment_date() {
    return appointment_date;
  }

  public void setAppointment_date(Date appointment_date) {
    this.appointment_date = appointment_date;
  }

  public Time getStart_time() {
    return start_time;
  }

  public void setStart_time(Time start_time) {
    this.start_time = start_time;
  }

  public Time getFinish_time() {
    return finish_time;
  }

  public void setFinish_time(Time finish_time) {
    this.finish_time = finish_time;
  }


  @Override
  public String toString() {
    return "InsAppointment{" +
            "name='" + name + '\'' +
            ", appointment_date=" + appointment_date +
            ", start_time=" + start_time +
            ", finish_time=" + finish_time +
            '}';
  }


}
