package com.group39.fitbot.group39_fitbot.model;

import java.time.LocalDate;

public class PhysicalBranchMessages {
    private int notice_no;
    private String title;
    private LocalDate dates;
    private String description;
    private String branch_name;

    public PhysicalBranchMessages() {
    }

    public PhysicalBranchMessages(int notice_no, String title, LocalDate dates, String description, String branch_name) {
        this.notice_no = notice_no;
        this.title = title;
        this.dates = dates;
        this.description = description;
        this.branch_name = branch_name;
    }

    public int getNotice_no() {
        return notice_no;
    }

    public void setNotice_no(int notice_no) {
        this.notice_no = notice_no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDates() {
        return dates;
    }

    public void setDates(LocalDate dates) {
        this.dates = dates;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }
}
