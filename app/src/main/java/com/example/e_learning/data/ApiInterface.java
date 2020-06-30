package com.example.e_learning.data;

import com.example.e_learning.pojo.StudentModel;
import com.example.e_learning.ui.login.LoginInformation;
import com.example.e_learning.ui.registration.RegisterUserInformation;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("register")
    public Call<StudentModel> RegisterMethod (@Body RegisterUserInformation registerUserInformation);

    @POST("login")
    public Call<StudentModel> LoginMethod (@Body LoginInformation loginInformation);

}
