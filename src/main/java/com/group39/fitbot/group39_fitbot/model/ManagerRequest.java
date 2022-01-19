package com.group39.fitbot.group39_fitbot.model;

import java.sql.Date;

public class ManagerRequest {
    private String equipment_id;
    private String category;
    private String status;
    private Date next_maintenance_date;

    public ManagerRequest(String equipment_id, String category, String status, Date next_maintenance_date) {
        this.equipment_id = equipment_id;
        this.category = category;
        this.status = status;
        this.next_maintenance_date = next_maintenance_date;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getNext_maintenance_date() {
        return next_maintenance_date;
    }

    public void setNext_maintenance_date(Date next_maintenance_date) {
        this.next_maintenance_date = next_maintenance_date;
    }

    @Override
    public String toString() {
        return "ManagerRequest{" +
                "equipment_id='" + equipment_id + '\'' +
                ", category='" + category + '\'' +
                ", status='" + status + '\'' +
                ", next_maintenance_date=" + next_maintenance_date +
                '}';
    }
}
