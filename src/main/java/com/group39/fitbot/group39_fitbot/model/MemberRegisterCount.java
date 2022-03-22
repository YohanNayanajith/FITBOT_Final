package com.group39.fitbot.group39_fitbot.model;

public class MemberRegisterCount {
    private String month;
    private int member_count;

    public MemberRegisterCount() {
    }

    public MemberRegisterCount(String month, int member_count) {
        this.month = month;
        this.member_count = member_count;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
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
                "month='" + month + '\'' +
                ", member_count=" + member_count +
                '}';
    }
}
