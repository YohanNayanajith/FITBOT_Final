package com.group39.fitbot.group39_fitbot.model;

public class ManagerMarkMemberAttendence {
    private Boolean status;

    public ManagerMarkMemberAttendence(Boolean status) {
        this.status = status;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ManagerMarkMemberAttendence{" +
                "status=" + status +
                '}';
    }
}
