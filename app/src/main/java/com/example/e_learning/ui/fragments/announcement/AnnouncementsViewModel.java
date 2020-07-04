package com.example.e_learning.ui.fragments.announcement;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.e_learning.data.StudentClient;
import com.example.e_learning.pojo.AnnouncementsModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnnouncementsViewModel extends ViewModel {

    private MutableLiveData<AnnouncementsModel> announcementsModelMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<Integer> studentId ;
    MutableLiveData<Integer> setStudentId() {

        if (studentId == null) {
            studentId = new MutableLiveData<>();
        }
        return studentId;

    }

    MutableLiveData<AnnouncementsModel> getResponse() {

        if (announcementsModelMutableLiveData == null) {
            announcementsModelMutableLiveData = new MutableLiveData<>();
        }
        return announcementsModelMutableLiveData;

    }

    void getAnnouncements()
    {
        StudentClient.getINSTANCE().getAnnouncements(studentId.getValue()).enqueue(new Callback<AnnouncementsModel>() {
            @Override
            public void onResponse(Call<AnnouncementsModel> call, Response<AnnouncementsModel> response) {
                announcementsModelMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<AnnouncementsModel> call, Throwable t) {

            }
        });
    }


}
