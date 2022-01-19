package com.group39.fitbot.group39_fitbot.model;

public class ManagerDashboard {
    private String manager_firstname;
    private String manager_lastname;
    private int branch_equipmentscount;
    private int branch_instructorscount;
    private int branch_membercount;

    public ManagerDashboard(String manager_firstname, String manager_lastname, int branch_equipmentscount, int branch_instructorscount, int branch_membercount) {
        this.manager_firstname = manager_firstname;
        this.manager_lastname = manager_lastname;
        this.branch_equipmentscount = branch_equipmentscount;
        this.branch_instructorscount = branch_instructorscount;
        this.branch_membercount = branch_membercount;
    }

    public String getManager_firstname() {
        return manager_firstname;
    }

    public void setManager_firstname(String manager_firstname) {
        this.manager_firstname = manager_firstname;
    }

    public String getManager_lastname() {
        return manager_lastname;
    }

    public void setManager_lastname(String manager_lastname) {
        this.manager_lastname = manager_lastname;
    }

    public int getBranch_equipmentscount() {
        return branch_equipmentscount;
    }

    public void setBranch_equipmentscount(int branch_equipmentscount) {
        this.branch_equipmentscount = branch_equipmentscount;
    }

    public int getBranch_instructorscount() {
        return branch_instructorscount;
    }

    public void setBranch_instructorscount(int branch_instructorscount) {
        this.branch_instructorscount = branch_instructorscount;
    }

    public int getBranch_membercount() {
        return branch_membercount;
    }

    public void setBranch_membercount(int branch_membercount) {
        this.branch_membercount = branch_membercount;
    }

    @Override
    public String toString() {
        return "ManagerDashboard{" +
                "manager_firstname='" + manager_firstname + '\'' +
                ", manager_lastname='" + manager_lastname + '\'' +
                ", branch_equipmentscount=" + branch_equipmentscount +
                ", branch_instructorscount=" + branch_instructorscount +
                ", branch_membercount=" + branch_membercount +
                '}';
    }
}
