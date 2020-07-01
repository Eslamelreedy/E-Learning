package com.example.e_learning.ui.selectcourses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.e_learning.R;
import com.example.e_learning.jsondata.AllCoursesData;
import com.example.e_learning.pojo.SelectCoursesModel;

import java.util.ArrayList;

public class SelectCourses extends AppCompatActivity {
    RecyclerView recyclerView;
    Button DoneBtn;
    ArrayList<String> selected;
    StringBuffer buffer = null;

    //
    SelectCoursesViewModel viewModel ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_courses);

        viewModel= new ViewModelProvider(this).get(SelectCoursesViewModel.class);
        //RecyclerView
        SelectCoursesAdapter adapter = new SelectCoursesAdapter();
        recyclerView = findViewById(R.id.RecyclerSelectCourses);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        viewModel.coursesModelMutableLiveData.observe(this, allCoursesModel -> {
            adapter.setList((ArrayList<AllCoursesData>) allCoursesModel.getData());


        });


        DoneBtn = findViewById(R.id.doneBtn);
        DoneBtn.setOnClickListener(v -> {
            ArrayList<AllCoursesData> selectedData = new ArrayList<>();
            selectedData = adapter.getSelected();

        });


    }


}
