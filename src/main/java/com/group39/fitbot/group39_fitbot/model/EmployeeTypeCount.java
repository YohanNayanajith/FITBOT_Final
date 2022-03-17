package com.group39.fitbot.group39_fitbot.model;

public class EmployeeTypeCount {
    private String branch_name;
    private int instructor_count;
    private int branchmanager_count;

    public EmployeeTypeCount() {
    }

    public EmployeeTypeCount(String branch_name, int instructor_count, int branchmanager_count) {
        this.branch_name = branch_name;
        this.instructor_count = instructor_count;
        this.branchmanager_count = branchmanager_count;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public int getInstructor_count() {
        return instructor_count;
    }

    public void setInstructor_count(int instructor_count) {
        this.instructor_count = instructor_count;
    }

    public int getBranchmanager_count() {
        return branchmanager_count;
    }

    public void setBranchmanager_count(int branchmanager_count) {
        this.branchmanager_count = branchmanager_count;
    }

    @Override
    public String toString() {
        return "EmployeeTypeCount{" +
                "branch_name='" + branch_name + '\'' +
                ", instructor_count=" + instructor_count +
                ", branchmanager_count=" + branchmanager_count +
                '}';
    }
}
