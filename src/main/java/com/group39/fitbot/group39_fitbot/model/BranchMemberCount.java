package com.group39.fitbot.group39_fitbot.model;

public class BranchMemberCount {
    private String branch_name;
    private int branchmember_count;

    public BranchMemberCount() {
    }

    public BranchMemberCount(String branch_name, int branchmember_count) {
        this.branch_name = branch_name;
        this.branchmember_count = branchmember_count;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public int getBranchmember_count() {
        return branchmember_count;
    }

    public void setBranchmember_count(int branchmember_count) {
        this.branchmember_count = branchmember_count;
    }

    @Override
    public String toString() {
        return "BranchMemberCount{" +
                "branch_name='" + branch_name + '\'' +
                ", branchmember_count=" + branchmember_count +
                '}';
    }
}
