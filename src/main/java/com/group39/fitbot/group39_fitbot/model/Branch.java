package com.group39.fitbot.group39_fitbot.model;

public class Branch {
    private String branch_id;
    private String branch_location;

    public Branch(String branch_id, String branch_location) {
        this.branch_id = branch_id;
        this.branch_location = branch_location;
    }

    public Branch() {

    }

    public String getBranch_id(String string) {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    public String getBranch_location() {
        return branch_location;
    }

    public void setBranch_location(String branch_location) {
        this.branch_location = branch_location;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branch_id='" + branch_id + '\'' +
                ", branch_location='" + branch_location + '\'' +
                '}';
    }
}
