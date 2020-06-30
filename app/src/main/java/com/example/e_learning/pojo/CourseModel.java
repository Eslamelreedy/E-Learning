package com.example.e_learning.pojo;

public class CourseModel {
    private String courseName;
    private String drName ;
    private String courseLvl ;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDrName() {
        return drName;
    }

    public void setDrName(String drName) {
        this.drName = drName;
    }

    public String getCourseLvl() {
        return courseLvl;
    }

    public void setCourseLvl(String courseLvl) {
        this.courseLvl = courseLvl;
    }

    public CourseModel(String coursename, String drName, String courseLvl) {
        this.courseName = coursename;
        this.drName = drName;
        this.courseLvl = courseLvl;
    }
}
