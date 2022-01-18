package com.group39.fitbot.group39_fitbot.model;

public class ManagerMemberView {
    private String firstname;
    private String lastname;
    private String membertype;
    private String intructorname;

    public ManagerMemberView(String firstname, String lastname, String membertype, String intructorname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.membertype = membertype;
        this.intructorname = intructorname;
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

    @Override
    public String toString() {
        return "ManagerMemberView{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", membertype='" + membertype + '\'' +
                ", intructorname='" + intructorname + '\'' +
                '}';
    }
}
