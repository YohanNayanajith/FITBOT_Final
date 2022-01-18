package com.group39.fitbot.group39_fitbot.model;

import java.sql.Date;
//import java.sql.Time;
import java.sql.Time;
import java.time.LocalTime;

public class ManagerAddRequest {
    private String equipment_id;
    private String category;
    private String description;
    private Date re_date;
    private LocalTime re_time;
    private String branchmanager_id;
    private String branch_id;

    public ManagerAddRequest(String equipment_id, String category, String description, Date re_date, LocalTime re_time, String branchmanager_id, String branch_id) {
        this.equipment_id = equipment_id;
        this.category = category;
        this.description = description;
        this.re_date = re_date;
        this.re_time = re_time;
        this.branchmanager_id = branchmanager_id;
        this.branch_id = branch_id;
    }

    public ManagerAddRequest() {

    }

    public String getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(String equipment_id) {
        this.equipment_id = equipment_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRe_date() {
        return re_date;
    }

    public void setRe_date(Date re_date) {
        this.re_date = re_date;
    }

    public LocalTime getRe_time() {
        return re_time;
    }

    public void setRe_time(LocalTime re_time) {
        this.re_time = re_time;
    }

    public String getBranchmanager_id() {
        return branchmanager_id;
    }

    public void setBranchmanager_id(String branchmanager_id) {
        this.branchmanager_id = branchmanager_id;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    @Override
    public String toString() {
        return "ManagerAddRequest{" +
                "equipment_id='" + equipment_id + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", re_date=" + re_date +
                ", re_time=" + re_time +
                ", branchmanager_id='" + branchmanager_id + '\'' +
                ", branch_id='" + branch_id + '\'' +
                '}';
    }
}
