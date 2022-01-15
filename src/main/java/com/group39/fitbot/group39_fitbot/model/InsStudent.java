package com.group39.fitbot.group39_fitbot.model;

import java.sql.Date;

public class InsStudent {

    private String name;
    private Date dob;
    private String gender;
    private String workout_plan_name;
    private String diet_plan_name;

    public InsStudent(String name, Date dob, String gender, String workout_plan_name, String diet_plan_name) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.workout_plan_name = workout_plan_name;
        this.diet_plan_name = diet_plan_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getWorkout_plan_name() {
        return workout_plan_name;
    }

    public void setWorkout_plan_name(String workout_plan_name) {
        this.workout_plan_name = workout_plan_name;
    }

    public String getDiet_plan_name() {
        return diet_plan_name;
    }

    public void setDiet_plan_name(String diet_plan_name) {
        this.diet_plan_name = diet_plan_name;
    }

    @Override
    public String toString() {
        return "InsStudent{" +
                "name='" + name + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                ", workout_plan_name='" + workout_plan_name + '\'' +
                ", diet_plan_name='" + diet_plan_name + '\'' +
                '}';
    }
}
