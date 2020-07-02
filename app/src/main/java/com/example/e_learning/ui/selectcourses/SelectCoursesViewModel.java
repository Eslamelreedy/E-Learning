package com.example.e_learning.ui.selectcourses;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.e_learning.data.StudentClient;
import com.example.e_learning.pojo.AddCourseResModel;
import com.example.e_learning.pojo.AllCoursesModel;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelectCoursesViewModel extends ViewModel {

    private MutableLiveData<AllCoursesModel> coursesModelMutableLiveData;

    private MutableLiveData<AddCourseResModel> addCourseResModelMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<HashMap<Object, Object>> mapMutableLiveData;


    MutableLiveData<HashMap<Object, Object>> getMapMutableLiveData() {

        if (mapMutableLiveData == null) {
            mapMutableLiveData = new MutableLiveData<>();
        }
        return mapMutableLiveData;

    }




    MutableLiveData<AllCoursesModel> getResponse() {

        if (coursesModelMutableLiveData == null) {
            coursesModelMutableLiveData = new MutableLiveData<>();
        }
        return coursesModelMutableLiveData;

    }

    MutableLiveData<AddCourseResModel> getAddCourseData() {

        if (addCourseResModelMutableLiveData == null) {
            addCourseResModelMutableLiveData = new MutableLiveData<>();
        }
        return addCourseResModelMutableLiveData;

    }





    void getAllCourses() {
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

    public void addCourse() {
        StudentClient.getINSTANCE().getResponseAddCourse(mapMutableLiveData.getValue()).enqueue(new Callback<AddCourseResModel>() {
            @Override
            public void onResponse(Call<AddCourseResModel> call, Response<AddCourseResModel> response) {
                addCourseResModelMutableLiveData.setValue(response.body());

            }

            @Override
            public void onFailure(Call<AddCourseResModel> call, Throwable t) {

            }
        });
    }
}
