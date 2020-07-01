
package com.example.e_learning.pojo;

import java.util.List;

import com.example.e_learning.jsondata.AllCoursesData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllCoursesModel {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("data")
    @Expose
    private List<AllCoursesData> data = null;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<AllCoursesData> getData() {
        return data;
    }

    public void setData(List<AllCoursesData> data) {
        this.data = data;
    }

}
