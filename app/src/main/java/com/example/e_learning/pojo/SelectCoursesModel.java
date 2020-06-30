package com.example.e_learning.pojo;

public class SelectCoursesModel {

    private String courseName;
    private String courseLvl ;
    private boolean isSelected;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }



    public String getCourseLvl() {
        return courseLvl;
    }

    public void setCourseLvl(String courseLvl) {
        this.courseLvl = courseLvl;
    }

    public SelectCoursesModel(String courseName, String courseLvl) {
        this.courseName = courseName;
        this.courseLvl = courseLvl;
    }
}
