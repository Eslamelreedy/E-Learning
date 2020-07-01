
package com.example.e_learning.jsondata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllCoursesData {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("level")
    @Expose
    private String level;
    @SerializedName("book")
    @Expose
    private Object book;
    @SerializedName("description")
    @Expose
    private String description;

    private boolean isSelected;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Object getBook() {
        return book;
    }

    public void setBook(Object book) {
        this.book = book;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public AllCoursesData(String name, String level) {
        this.name = name;
        this.level = level;
    }
}
