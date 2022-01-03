package com.group39.fitbot.group39_fitbot.model;

public class InstructorDescriptionView{
    private String instructor_id;
    private String description;
    private int duration;
    private String country;
    private int price;

    public InstructorDescriptionView() {
    }

    public InstructorDescriptionView(String instructor_id, String description, int duration, String country, int price) {
        this.instructor_id = instructor_id;
        this.description = description;
        this.duration = duration;
        this.country = country;
        this.price = price;
    }

    public String getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(String instructor_id) {
        this.instructor_id = instructor_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
