package com.example.e_learning.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.e_learning.jsondata.StudentData;
import com.example.e_learning.pojo.StudentModel;

public class SharedPrefManger {
    private static SharedPrefManger INSTANCE;
    private Context context;
    private static final String SHARED_PREF_NAME = "MySharedPref";

    public SharedPrefManger(Context context) {
        this.context = context;
    }

    public static SharedPrefManger getINSTANCE(Context context) {
        if (INSTANCE == null)
            INSTANCE = new SharedPrefManger(context);
        return INSTANCE;

    }

    public void saveUser(StudentData data) {
        SharedPreferences preferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putInt("id", data.getId());
        editor.putString("email", data.getEmail());
        editor.putString("name", data.getName());
        editor.putString("level", data.getLevel());

        editor.apply();
    }

    public boolean isLoggedIn() {
        SharedPreferences preferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return preferences.getInt("id", -1) != -1;
    }

    public StudentData getUser() {
        SharedPreferences preferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        return new StudentData(
                preferences.getInt("id", -1),
                preferences.getString("name", null),
                preferences.getString("email", null),
                preferences.getString("level", null)
        );

    }
    public void clear(){
        SharedPreferences preferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();

    }
}
