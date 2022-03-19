package com.group39.fitbot.group39_fitbot.model;

import java.sql.Date;
import java.time.LocalDate;

public class ManagerMemberView {
    private String member_id;
    private String firstname;
    private String lastname;
    private String membertype;
    private String intructorname;
    private LocalDate date;
    private int status;

    public ManagerMemberView(String member_id, String firstname, String lastname, String membertype, String intructorname, LocalDate date, int status) {
        this.member_id = member_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.membertype = membertype;
        this.intructorname = intructorname;
        this.date = date;
        this.status = status;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMembertype() {
        return membertype;
    }

    public void setMembertype(String membertype) {
        this.membertype = membertype;
    }

    public String getIntructorname() {
        return intructorname;
    }

    public void setIntructorname(String intructorname) {
        this.intructorname = intructorname;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ManagerMemberView{" +
                "member_id='" + member_id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", membertype='" + membertype + '\'' +
                ", intructorname='" + intructorname + '\'' +
                ", date=" + date +
                ", status=" + status +
                '}';
    }
}
