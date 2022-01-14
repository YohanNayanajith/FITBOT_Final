package com.group39.fitbot.group39_fitbot.model;

import java.sql.Date;

public class Notice {
    private String title;
    private Date dates;
    private String description;

public Notice() {

}
    public Notice(String title, Date dates, String description) {
        this.title = title;
        this.dates = dates;
        this.description = description;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "title='" + title + '\'' +
                ", dates=" + dates +
                ", description='" + description + '\'' +
                '}';
    }
}
