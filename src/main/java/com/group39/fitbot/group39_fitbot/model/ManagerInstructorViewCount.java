package com.group39.fitbot.group39_fitbot.model;

public class ManagerInstructorViewCount {
    private int instructor_present_count;
    private int total_instructor_count;

    public ManagerInstructorViewCount(int instructor_present_count, int total_instructor_count) {
        this.instructor_present_count = instructor_present_count;
        this.total_instructor_count = total_instructor_count;
    }

    public int getInstructor_present_count() {
        return instructor_present_count;
    }

    public void setInstructor_present_count(int instructor_present_count) {
        this.instructor_present_count = instructor_present_count;
    }

    public int getTotal_instructor_count() {
        return total_instructor_count;
    }

    public void setTotal_instructor_count(int total_instructor_count) {
        this.total_instructor_count = total_instructor_count;
    }

    @Override
    public String toString() {
        return "ManagerInstructorViewCount{" +
                "instructor_present_count=" + instructor_present_count +
                ", total_instructor_count=" + total_instructor_count +
                '}';
    }
}
