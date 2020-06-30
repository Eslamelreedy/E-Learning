package com.example.e_learning.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_learning.R;

public class UploadQuestionActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;

    TextView urlTextView;
    ImageButton uploadingBTN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_question);
        uploadingBTN = findViewById(R.id.chooseFileBtn);
        urlTextView = findViewById(R.id.urlText);

        uploadingBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FindFile();

            }
        });
    }

    public void FindFile() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("application/pdf");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            if (data != null) {
                Uri uri = data.getData();
                assert uri != null;
                Toast.makeText(this, "path" + uri.getPath(), Toast.LENGTH_SHORT).show();
                urlTextView.setText(uri.getPath());
            }
        }
    }
}

