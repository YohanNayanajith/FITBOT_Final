package com.group39.fitbot.group39_fitbot.model;

public class BranchMemberCount {
    private String branch_name;
    private int unbanmember_count;
    private int banmember_count;

    public BranchMemberCount(String branch_name) {
        this.branch_name = branch_name;
    }

    public BranchMemberCount(String branch_name, int unbanmember_count, int banmember_count) {
        this.branch_name = branch_name;
        this.unbanmember_count = unbanmember_count;
        this.banmember_count = banmember_count;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public int getUnbanmember_count() {
        return unbanmember_count;
    }

    public void setUnbanmember_count(int unbanmember_count) {
        this.unbanmember_count = unbanmember_count;
    }

    public int getBanmember_count() {
        return banmember_count;
    }

    public void setBanmember_count(int banmember_count) {
        this.banmember_count = banmember_count;
    }

    @Override
    public String toString() {
        return "BranchMemberCount{" +
                "branch_name='" + branch_name + '\'' +
                ", unbanmember_count=" + unbanmember_count +
                ", banmember_count=" + banmember_count +
                '}';
    }
}
