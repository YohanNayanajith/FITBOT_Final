package com.group39.fitbot.group39_fitbot.model;

public class MemberRegisterCount {
    private String month;
    private int member_count;

    public MemberRegisterCount() {
    }

    public MemberRegisterCount(String month, int member_count) {
        month = month;
        this.member_count = member_count;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        month = month;
    }

    public int getMember_count() {
        return member_count;
    }

    public void setMember_count(int member_count) {
        this.member_count = member_count;
    }

    @Override
    public String toString() {
        return "MemberRegisterCount{" +
                "Month='" + month + '\'' +
                ", member_count=" + member_count +
                '}';
    }
}
