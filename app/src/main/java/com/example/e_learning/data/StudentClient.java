package com.example.e_learning.data;


import com.example.e_learning.core.MyApplication;
import com.example.e_learning.pojo.AddCourseResModel;
import com.example.e_learning.pojo.AllCoursesModel;
import com.example.e_learning.pojo.AnnouncementsModel;
import com.example.e_learning.pojo.StudentModel;
import com.example.e_learning.ui.login.LoginInformation;
import com.example.e_learning.ui.registration.RegisterUserInformation;
import com.readystatesoftware.chuck.ChuckInterceptor;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StudentClient {

    private static final String BASE_URL = "http://salemsaber.com/websites/elearning/api/student/";
    private ApiInterface apiInterface;
    private static StudentClient INSTANCE;

    private Long CONNECT_TIMEOUT = 60L; // in secs
    private Long READ_TIMEOUT = 60L; // in secs

    public StudentClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new ChuckInterceptor(new MyApplication().getInstance()))
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface = retrofit.create(ApiInterface.class);


    }

    public static StudentClient getINSTANCE() {
        if (null == INSTANCE) {
            INSTANCE = new StudentClient();
        }
        return INSTANCE;
    }

    public Call<StudentModel> RegisterUser(RegisterUserInformation user) {
        return apiInterface.RegisterMethod(user);
    }

    public Call<StudentModel> LoginUser(LoginInformation loginInformation) {
        return apiInterface.LoginMethod(loginInformation);
    }

    public Call<AllCoursesModel> getAllCourses() {
        return apiInterface.getAllCourses();
    }

    public Call<AddCourseResModel> getResponseAddCourse(HashMap<Object, Object> map) {
        return apiInterface.getResponseAddCourse(map);
    }

    public Call<AnnouncementsModel> getAnnouncements(Integer integer) {
        return apiInterface.getAnnouncements(integer);
    }

}
