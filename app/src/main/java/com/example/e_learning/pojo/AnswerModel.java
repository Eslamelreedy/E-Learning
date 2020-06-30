package com.example.e_learning.pojo;

public class AnswerModel {
    private String AQsubject ;
    private String chapter_number ;
    private String slide_number ;
    private String  question_body ;

    public AnswerModel(String AQsubject, String chapter_number, String slide_number, String question_body) {
        this.AQsubject = AQsubject;
        this.chapter_number = chapter_number;
        this.slide_number = slide_number;
        this.question_body = question_body;

    }

    public String getAQsubject() {
        return AQsubject;
    }

    public void setAQsubject(String AQsubject) {
        this.AQsubject = AQsubject;
    }

    public String getChapter_number() {
        return chapter_number;
    }

    public void setChapter_number(String chapter_number) {
        this.chapter_number = chapter_number;
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
