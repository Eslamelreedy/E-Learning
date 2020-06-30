
package com.example.e_learning.jsondata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StudentData {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("level")
    @Expose
    private String level;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public StudentData(Integer id, String name, String email, String level) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.level = level;
    }
}
