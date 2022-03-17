package com.group39.fitbot.group39_fitbot.model;

public class BranchEquipmentCount {
    private String branch_name;
    private int equipment_count;

    public BranchEquipmentCount() {
    }

    public BranchEquipmentCount(String branch_name, int equipment_count) {
        this.branch_name = branch_name;
        this.equipment_count = equipment_count;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public int getEquipment_count() {
        return equipment_count;
    }

    public void setEquipment_count(int equipment_count) {
        this.equipment_count = equipment_count;
    }

    @Override
    public String toString() {
        return "BranchEquipmentCount{" +
                "branch_name='" + branch_name + '\'' +
                ", equipment_count='" + equipment_count + '\'' +
                '}';
    }
}
