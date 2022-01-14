package com.group39.fitbot.group39_fitbot.model;

public class InsStudentBoxRequest {
    private String member_id;
    private String instructor_id;
    private int status;
    private int member_status;

    public InsStudentBoxRequest() {
    }

    public InsStudentBoxRequest(String member_id, String instructor_id, int status, int member_status) {
        this.member_id = member_id;
        this.instructor_id = instructor_id;
        this.status = status;
        this.member_status = member_status;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(String instructor_id) {
        this.instructor_id = instructor_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getMember_status() {
        return member_status;
    }

    public void setMember_status(int member_status) {
        this.member_status = member_status;
    }

    @Override
    public String toString() {
        return "InsStudentBoxRequest{" +
                "member_id='" + member_id + '\'' +
                ", instructor_id='" + instructor_id + '\'' +
                ", status=" + status +
                ", member_status=" + member_status +
                '}';
    }
}
