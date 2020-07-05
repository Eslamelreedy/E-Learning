package com.example.e_learning.data;

import com.example.e_learning.pojo.AddCourseResModel;
import com.example.e_learning.pojo.AllCoursesModel;
import com.example.e_learning.pojo.AnnouncementsModel;
import com.example.e_learning.pojo.StudentModel;
import com.example.e_learning.ui.login.LoginInformation;
import com.example.e_learning.ui.registration.RegisterUserInformation;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("register")
    Call<StudentModel> RegisterMethod(@Body RegisterUserInformation registerUserInformation);

    @POST("login")
    Call<StudentModel> LoginMethod(@Body LoginInformation loginInformation);

    @POST("allCourses")
    Call<AllCoursesModel> getAllCourses();

    @POST("addCourse")
    public Call<AddCourseResModel> getResponseAddCourse (@Body HashMap<Object,Object> map);

    @POST("viewPosts")
    @FormUrlEncoded
    public Call<AnnouncementsModel> getAnnouncements (@Field("studentId") Integer studentId);



}
