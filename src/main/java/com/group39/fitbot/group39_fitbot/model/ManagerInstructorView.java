package com.group39.fitbot.group39_fitbot.model;

public class ManagerInstructorView {
    private String first_name;
    private String last_name;
    private int mem_count;
    private int appoinment_count;

    public ManagerInstructorView(String first_name, String last_name, int mem_count, int appoinment_count) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.mem_count = mem_count;
        this.appoinment_count = appoinment_count;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getMem_count() {
        return mem_count;
    }

    public void setMem_count(int mem_count) {
        this.mem_count = mem_count;
    }

    public int getAppoinment_count() {
        return appoinment_count;
    }

    public void setAppoinment_count(int appoinment_count) {
        this.appoinment_count = appoinment_count;
    }

    @Override
    public String toString() {
        return "ManagerInstructorView{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", mem_count=" + mem_count +
                ", appoinment_count=" + appoinment_count +
                '}';
    }
}

