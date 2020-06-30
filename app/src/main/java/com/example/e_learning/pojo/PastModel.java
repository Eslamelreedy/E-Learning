package com.example.e_learning.pojo;

public class PastModel {
    private String deliverd ;
    private String subject_name ;
    private String sheet_number ;
    private String  grade ;

    public String getDeliverd() {
        return deliverd;
    }

    public void setDeliverd(String deliverd) {
        this.deliverd = deliverd;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getSheet_number() {
        return sheet_number;
    }

    public void setSheet_number(String sheet_number) {
        this.sheet_number = sheet_number;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public PastModel(String deliverd, String subject_name, String sheet_number, String grade) {
        this.deliverd = deliverd;
        this.subject_name = subject_name;
        this.sheet_number = sheet_number;
        this.grade = grade;
    }

}
