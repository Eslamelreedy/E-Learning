package com.example.e_learning.ui.registration;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.e_learning.R;
import com.example.e_learning.databinding.ActivityRegistrationBinding;

import java.util.Objects;

public class RegistrationActivity extends AppCompatActivity {


    StudentViewModel model;
    ActivityRegistrationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model = new ViewModelProvider(this).get(StudentViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_registration);
        binding.setLifecycleOwner(this);
        binding.setStudentViewModel(model);
//
        model.getUser().observe(this, registerUser -> {


            if (TextUtils.isEmpty(Objects.requireNonNull(registerUser).getEmail())) {
                binding.EmailRegEditText.setError("Enter an E-Mail Address");
                binding.EmailRegEditText.requestFocus();
            } else if (!registerUser.isEmailValid()) {
                binding.EmailRegEditText.setError("Enter a Valid E-mail Address");
                binding.EmailRegEditText.requestFocus();
            } else if (TextUtils.isEmpty(Objects.requireNonNull(registerUser).getPassword())) {
                binding.RegPasswordEditText.setError("Enter a Password");
                binding.RegPasswordEditText.requestFocus();
            } else if (!registerUser.isPasswordLengthGreaterThan8()) {
                binding.RegPasswordEditText.setError("Enter at least 8 Digit password");
                binding.RegPasswordEditText.requestFocus();
            } else {
                Toast.makeText(this, registerUser.getEmail() + " " + registerUser.getLevel(), Toast.LENGTH_SHORT).show();

            }


        });

        model.receivedData.observe(this, studentModell ->
                Toast.makeText(RegistrationActivity.this, studentModell.getStudentData().getName(), Toast.LENGTH_SHORT).show());

        model.error.observe(this, s -> {
            Toast.makeText(this, s, Toast.LENGTH_SHORT).show();

        });
    }



}

