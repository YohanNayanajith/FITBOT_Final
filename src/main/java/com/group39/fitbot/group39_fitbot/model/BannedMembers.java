package com.group39.fitbot.group39_fitbot.model;

import java.time.LocalDate;

public class BannedMembers {
    private String member_id;
    private String reason;
    LocalDate Banned_Date;

    public BannedMembers() {
    }

    public BannedMembers(String member_id, String reason, LocalDate banned_Date) {
        this.member_id = member_id;
        this.reason = reason;
        Banned_Date = banned_Date;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDate getBanned_Date() {
        return Banned_Date;
    }

    public void setBanned_Date(LocalDate banned_Date) {
        Banned_Date = banned_Date;
    }
}
