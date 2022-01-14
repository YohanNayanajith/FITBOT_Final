package com.group39.fitbot.group39_fitbot.model;

import java.sql.Date;

public class NoticeBranchMnagaer {
    private String title;
    private Date dates;
    private String description;
    private String branchmanager_id;

    public NoticeBranchMnagaer(String title, Date dates, String description, String branchmanager_id) {
        this.title = title;
        this.dates = dates;
        this.description = description;
        this.branchmanager_id = branchmanager_id;
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

    public String getBranchmanager_id() {
        return branchmanager_id;
    }

    public void setBranchmanager_id(String branchmanager_id) {
        this.branchmanager_id = branchmanager_id;
    }

    @Override
    public String toString() {
        return "NoticeBranchMnagaer{" +
                "title='" + title + '\'' +
                ", dates=" + dates +
                ", description='" + description + '\'' +
                ", branchmanager_id='" + branchmanager_id + '\'' +
                '}';
    }
}
