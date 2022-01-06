package com.group39.fitbot.group39_fitbot.model;

public class MemberInstructorDetail {
    private String member_id;
    private String instructor_id;
    private String branch_id;

    public MemberInstructorDetail() {
    }

    public MemberInstructorDetail(String member_id, String instructor_id, String branch_id) {
        this.member_id = member_id;
        this.instructor_id = instructor_id;
        this.branch_id = branch_id;
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

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }
}
