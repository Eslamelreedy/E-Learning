package com.example.e_learning.ui.login;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.e_learning.R;
import com.example.e_learning.databinding.ActivityLoginBinding;
import com.example.e_learning.pojo.StudentModel;
import com.example.e_learning.storage.SharedPrefManger;
import com.example.e_learning.ui.fragments.Announcement.AnnouncementFragment;
import com.example.e_learning.ui.registration.RegistrationActivity;
import com.example.e_learning.ui.registration.StudentViewModel;

import java.util.Objects;


public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    LoginViewModel loginViewModel;


    @Override
    protected void onStart() {
        super.onStart();
        if (SharedPrefManger.getINSTANCE(this).isLoggedIn())
        {

            Intent intent = new Intent(LoginActivity.this,AnnouncementFragment.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setLifecycleOwner(this);
        binding.setLoginViewModel(loginViewModel);

        loginViewModel.getUser().observe(this, loginInformation -> {

            if (TextUtils.isEmpty(Objects.requireNonNull(loginInformation).getEmail())) {
                binding.EmailEditText.setError("Enter an E-Mail Address");
                binding.EmailEditText.requestFocus();
            } else if (TextUtils.isEmpty(Objects.requireNonNull(loginInformation).getPassword())) {
                binding.PasswordEditText.setError("Enter a Password");
                binding.PasswordEditText.requestFocus();

            } else {


            }

        });
//

        loginViewModel.getResponse().observe(this, studentModel -> {


            if (studentModel.getStatus()) {
                //Intent intent = new Intent(LoginActivity.this,AnnouncementFragment.class);
                Toast.makeText(LoginActivity.this, "success", Toast.LENGTH_SHORT).show();
                SharedPrefManger.getINSTANCE(LoginActivity.this).saveUser(studentModel.getStudentData());

                Intent intent = new Intent(LoginActivity.this,AnnouncementFragment.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            }
            else
            {
                Toast.makeText(LoginActivity.this, "Failed.."+ studentModel.getError(), Toast.LENGTH_SHORT).show();

            }
        });

    }


}
