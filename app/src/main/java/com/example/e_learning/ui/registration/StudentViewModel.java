package com.example.e_learning.ui.registration;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.e_learning.data.StudentClient;
import com.example.e_learning.pojo.StudentModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentViewModel extends ViewModel {


    public MutableLiveData<String> name = new MutableLiveData<>();
    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    public MutableLiveData<String> confirm_password = new MutableLiveData<>();
    public MutableLiveData<String> level = new MutableLiveData<>();
    private MutableLiveData<RegisterUserInformation> userMutableLiveData;
    public MutableLiveData<String> error = new MutableLiveData<>();
    MutableLiveData<StudentModel> receivedData = new MutableLiveData<>();


    public MutableLiveData<RegisterUserInformation> getUser() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;


    }

    public void onClick(View view) {

        RegisterUserInformation Register = new RegisterUserInformation(name.getValue(), email.getValue(), password.getValue(), confirm_password.getValue(), level.getValue());

        userMutableLiveData.setValue(Register);
        RegisterUser();

    }

    public void RegisterUser() {
        StudentClient.getINSTANCE().RegisterUser(userMutableLiveData.getValue()).enqueue(new Callback<StudentModel>() {
            @Override
            public void onResponse(Call<StudentModel> call, Response<StudentModel> response) {
                receivedData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<StudentModel> call, Throwable t) {
                error.setValue(t.getMessage());



            }


        });
    }
}
