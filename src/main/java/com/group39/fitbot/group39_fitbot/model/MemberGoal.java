package com.group39.fitbot.group39_fitbot.model;

public class MemberGoal {
    private String member_id;
    private double weight_goal;
    private double calory_goal;

    public MemberGoal() {
    }

    public MemberGoal(String member_id, double weight_goal, double calory_goal) {
        this.member_id = member_id;
        this.weight_goal = weight_goal;
        this.calory_goal = calory_goal;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public double getWeight_goal() {
        return weight_goal;
    }

    public void setWeight_goal(double weight_goal) {
        this.weight_goal = weight_goal;
    }

    public double getCalory_goal() {
        return calory_goal;
    }

    public void setCalory_goal(double calory_goal) {
        this.calory_goal = calory_goal;
    }
}
