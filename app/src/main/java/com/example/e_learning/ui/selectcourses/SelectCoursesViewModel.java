package com.example.e_learning.ui.selectcourses;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.e_learning.data.StudentClient;
import com.example.e_learning.pojo.AllCoursesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelectCoursesViewModel extends ViewModel {

    MutableLiveData<AllCoursesModel> coursesModelMutableLiveData = new MutableLiveData<>();


    public void getAllCourses(){
        StudentClient.getINSTANCE().getAllCourses().enqueue(new Callback<AllCoursesModel>() {
            @Override
            public void onResponse(Call<AllCoursesModel> call, Response<AllCoursesModel> response) {
                coursesModelMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<AllCoursesModel> call, Throwable t) {

            }
        });
    }
}
