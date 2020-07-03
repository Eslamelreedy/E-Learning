
package com.example.e_learning.pojo;

import java.util.List;

import com.example.e_learning.jsondata.AnnouncementsData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnnouncementsModel {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("data")
    @Expose
    private List<AnnouncementsData> data = null;

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

    public List<AnnouncementsData> getData() {
        return data;
    }

    public void setData(List<AnnouncementsData> data) {
        this.data = data;
    }

}
