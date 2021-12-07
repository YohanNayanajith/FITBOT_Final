package com.group39.fitbot.group39_fitbot.model;

import java.time.LocalDate;

public class UpdateWeight {
    private int weight_id;
    private String member_id;
    private LocalDate update_date;
    private int daily_count;
    private double previous_weight;
    private double new_weight;

    public UpdateWeight() {
    }

    public UpdateWeight(int weight_id, String member_id, LocalDate update_date, int daily_count, double previous_weight, double new_weight) {
        this.weight_id = weight_id;
        this.member_id = member_id;
        this.update_date = update_date;
        this.daily_count = daily_count;
        this.previous_weight = previous_weight;
        this.new_weight = new_weight;
    }

    public int getWeight_id() {
        return weight_id;
    }

    public void setWeight_id(int weight_id) {
        this.weight_id = weight_id;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public LocalDate getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(LocalDate update_date) {
        this.update_date = update_date;
    }

    public int getDaily_count() {
        return daily_count;
    }

    public void setDaily_count(int daily_count) {
        this.daily_count = daily_count;
    }

    public double getPrevious_weight() {
        return previous_weight;
    }

    public void setPrevious_weight(double previous_weight) {
        this.previous_weight = previous_weight;
    }

    public double getNew_weight() {
        return new_weight;
    }

    public void setNew_weight(double new_weight) {
        this.new_weight = new_weight;
    }
}
