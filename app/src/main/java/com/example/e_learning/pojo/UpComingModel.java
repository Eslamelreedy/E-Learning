package com.example.e_learning.pojo;

public class UpComingModel {
    private String deadline ;
    private String deadline_date ;
    private String subject_name ;
    private String sheet_number ;
    private String  uploading_date ;


    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getDeadline_date() {
        return deadline_date;
    }

    public void setDeadline_date(String deadline_date) {
        this.deadline_date = deadline_date;
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

    public String getUploading_date() {
        return uploading_date;
    }

    public void setUploading_date(String uploading_date) {
        this.uploading_date = uploading_date;
    }



    public UpComingModel(String deadline, String deadline_date , String subject_name , String sheet_number, String uploading_date){

        this.deadline=deadline;
        this.deadline_date=deadline_date;
        this.subject_name=subject_name;
        this.sheet_number=sheet_number;
        this.uploading_date=uploading_date;


    }
}
