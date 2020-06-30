package com.example.e_learning.pojo;

public class SentModel {
    private String subject ;
    private String chapter_number ;
    private String slide_number ;
    private String  question_body ;

    public SentModel(String subject,String chapter_number,String slide_number,String question_body) {
        this.subject = subject;
        this.chapter_number = chapter_number;
        this.slide_number = slide_number;
        this.question_body = question_body;
    }

    public String getChapter_number() {
        return chapter_number;
    }

    public void setChapter_number(String chapter_number) {
        this.chapter_number = chapter_number;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSlide_number() {
        return slide_number;
    }

    public void setSlide_number(String slide_number) {
        this.slide_number = slide_number;
    }

    public String getQuestion_body() {
        return question_body;
    }

    public void setQuestion_body(String question_body) {
        this.question_body = question_body;
    }
}
