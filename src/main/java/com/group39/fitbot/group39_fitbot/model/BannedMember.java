package com.group39.fitbot.group39_fitbot.model;

import java.time.LocalDate;

public class BannedMember extends AdminMember{
    private String banned_reason;
    LocalDate banned_date;

    public BannedMember() {
    }

    public BannedMember(String member_id, String first_name, String last_name, String contact_no, String gender, String branch_name, String membership, String email, LocalDate due_date, String type, String banned_reason, LocalDate banned_date) {
        this.member_id = member_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.contact_no = contact_no;
        this.gender = gender;
        this.branch_name = branch_name;
        this.membership = membership;
        this.email = email;
        this.due_date = due_date;
        this.type = type;
        this.banned_reason = banned_reason;
        this.banned_date = banned_date;
    }

    public BannedMember(String member_id,String banned_reason, LocalDate banned_date) {
        this.member_id = member_id;
        this.banned_reason = banned_reason;
        this.banned_date = banned_date;
    }

    public String getBanned_reason() {
        return banned_reason;
    }

    public void setBanned_reason(String banned_reason) {
        this.banned_reason = banned_reason;
    }

    public LocalDate getBanned_date() {
        return banned_date;
    }

    public void setBanned_date(LocalDate banned_date) {
        this.banned_date = banned_date;
    }

    @Override
    public String toString() {
        return "BannedMember{" +
                "member_id='" + member_id + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", contact_no='" + contact_no + '\'' +
                ", gender='" + gender + '\'' +
                ", branch_name='" + branch_name + '\'' +
                ", membership='" + membership + '\'' +
                ", email='" + email + '\'' +
                ", due_date=" + due_date +
                ", type='" + type + '\'' +
                ", banned_reason='" + banned_reason + '\'' +
                ", banned_date=" + banned_date +
                '}';
    }
}
