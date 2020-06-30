package com.example.e_learning.ui.login;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.e_learning.data.StudentClient;
import com.example.e_learning.pojo.StudentModel;
import com.example.e_learning.storage.SharedPrefManger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends ViewModel {

    public MutableLiveData<String> email = new MutableLiveData<>();
    public  MutableLiveData<String> password = new MutableLiveData<>();

    private MutableLiveData<LoginInformation> informationMutableLiveData;
    MutableLiveData<StudentModel> receivedData ;


    public MutableLiveData<LoginInformation> getUser() {

        if (informationMutableLiveData == null) {
            informationMutableLiveData = new MutableLiveData<>();
        }
        return informationMutableLiveData;

    }
    public void onClick(View view) {

        LoginInformation loginUser = new LoginInformation(email.getValue(), password.getValue());

        informationMutableLiveData.setValue(loginUser);
        LoginUser();

    }

    public MutableLiveData<StudentModel> getResponse() {

        if (receivedData == null) {
            receivedData = new MutableLiveData<>();
        }
        return receivedData;

    }
    private void LoginUser ()
    {
        StudentClient.getINSTANCE().LoginUser(informationMutableLiveData.getValue()).enqueue(new Callback<StudentModel>() {
            @Override
            public void onResponse(Call<StudentModel> call, Response<StudentModel> response) {
                receivedData.setValue(response.body());



            }

            @Override
            public void onFailure(Call<StudentModel> call, Throwable t) {

            }
        });
    }


}
