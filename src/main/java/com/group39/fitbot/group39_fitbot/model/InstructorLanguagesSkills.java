package com.group39.fitbot.group39_fitbot.model;

public class InstructorLanguagesSkills {
    private String language;
    private String skills;

    public InstructorLanguagesSkills() {
    }

    public InstructorLanguagesSkills(String language) {
        this.language = language;
    }

    public InstructorLanguagesSkills(String language, String skills) {
        this.language = language;
        this.skills = skills;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}
