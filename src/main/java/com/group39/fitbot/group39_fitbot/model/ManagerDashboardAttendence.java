package com.group39.fitbot.group39_fitbot.model;

public class ManagerDashboardAttendence {
    private int branch_revenue;
    private int member_attendence_count;
    private int instructor_attendence_count;
    private int appoinment_count;

    public ManagerDashboardAttendence(int branch_revenue, int member_attendence_count, int instructor_attendence_count, int appoinment_count) {
        this.branch_revenue = branch_revenue;
        this.member_attendence_count = member_attendence_count;
        this.instructor_attendence_count = instructor_attendence_count;
        this.appoinment_count = appoinment_count;
    }

    public int getBranch_revenue() {
        return branch_revenue;
    }

    public void setBranch_revenue(int branch_revenue) {
        this.branch_revenue = branch_revenue;
    }

    public int getMember_attendence_count() {
        return member_attendence_count;
    }

    public void setMember_attendence_count(int member_attendence_count) {
        this.member_attendence_count = member_attendence_count;
    }

    public int getInstructor_attendence_count() {
        return instructor_attendence_count;
    }

    public void setInstructor_attendence_count(int instructor_attendence_count) {
        this.instructor_attendence_count = instructor_attendence_count;
    }

    public int getAppoinment_count() {
        return appoinment_count;
    }

    public void setAppoinment_count(int appoinment_count) {
        this.appoinment_count = appoinment_count;
    }

    @Override
    public String toString() {
        return "ManagerDashboardAttendence{" +
                "branch_revenue=" + branch_revenue +
                ", member_attendence_count=" + member_attendence_count +
                ", instructor_attendence_count=" + instructor_attendence_count +
                ", appoinment_count=" + appoinment_count +
                '}';
    }
}
