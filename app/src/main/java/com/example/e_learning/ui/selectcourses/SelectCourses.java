package com.example.e_learning.ui.selectcourses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.e_learning.R;
import com.example.e_learning.databinding.ActivitySelectCoursesBinding;
import com.example.e_learning.jsondata.AllCoursesData;
import com.example.e_learning.pojo.AddCourseResModel;
import com.example.e_learning.pojo.SelectCoursesModel;
import com.example.e_learning.storage.SharedPrefManger;
import com.example.e_learning.ui.drawer.Drawer;

import java.util.ArrayList;
import java.util.HashMap;

public class SelectCourses extends AppCompatActivity {
    //
    SelectCoursesViewModel viewModel;
    ActivitySelectCoursesBinding coursesBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        coursesBinding = DataBindingUtil.setContentView(this, R.layout.activity_select_courses);


        viewModel = new ViewModelProvider(this).get(SelectCoursesViewModel.class);
        //RecyclerView
        SelectCoursesAdapter adapter = new SelectCoursesAdapter();
        //this is comment test

        coursesBinding.RecyclerSelectCourses.setLayoutManager(new LinearLayoutManager(this));
        coursesBinding.RecyclerSelectCourses.setAdapter(adapter);

        viewModel.getAllCourses();

        viewModel.getResponse().observe(this, allCoursesModel -> {
            if (allCoursesModel.getStatus()) {
                Toast.makeText(this, "Data Arrived", Toast.LENGTH_SHORT).show();
                adapter.setList((ArrayList<AllCoursesData>) allCoursesModel.getData());
                adapter.setOnItemClickListener(new SelectCoursesAdapter.ItemClickListener() {
                    @Override
                    public void OnItemClick(int position) {
                    }

                    @Override
                    public void OnAddCourseClick(int position) {

                        int studentId = SharedPrefManger.getINSTANCE(SelectCourses.this)
                                .getUser().getId();
                        int courseId = allCoursesModel.getData().get(position).getId();
                        HashMap<Object, Object> map = new HashMap<>();
                        map.put("studentId", studentId);
                        map.put("courseId", courseId);

                        viewModel.getMapMutableLiveData().setValue(map);
                        viewModel.addCourse();
                        viewModel.getAddCourseData().observe(SelectCourses.this, addCourseResModel -> {
                            Toast.makeText(SelectCourses.this, addCourseResModel.getStatus().toString(), Toast.LENGTH_SHORT).show();
                        });
                    }
                });
            } else {
                Toast.makeText(this, allCoursesModel.getError(), Toast.LENGTH_SHORT).show();
            }
        });

        coursesBinding.doneBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, Drawer.class);
            startActivity(intent);
        });

    }
}
