package com.example.e_learning.ui.selectcourses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.e_learning.R;
import com.example.e_learning.pojo.SelectCoursesModel;

import java.util.ArrayList;

public class SelectCourses extends AppCompatActivity {
    RecyclerView recyclerView;
    Button DoneBtn;
    ArrayList<String> selected;
    StringBuffer buffer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_courses);
        SelectCoursesAdapter adapter = new SelectCoursesAdapter(coursesModelArrayList());
        recyclerView = findViewById(R.id.RecyclerSelectCourses);
        DoneBtn =findViewById(R.id.doneBtn);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        DoneBtn.setOnClickListener(v -> {
            buffer = new StringBuffer();
            for (int i = 0; i < adapter.getSelected().size(); i++) {
                buffer.append(adapter.getSelected().get(i).getCourseName());
                buffer.append("\n");
            }
            if (adapter.getSelected().size()>0)
            {
                Toast.makeText(this, buffer.toString(), Toast.LENGTH_SHORT).show();
            }

        });


    }

    private ArrayList<SelectCoursesModel> coursesModelArrayList() {
        ArrayList<SelectCoursesModel> list = new ArrayList<>();
        list.add(new SelectCoursesModel("OOP", "two"));
        list.add(new SelectCoursesModel("DB", "ONE"));
        list.add(new SelectCoursesModel("OP", "two"));
        list.add(new SelectCoursesModel("OB", "two"));
        list.add(new SelectCoursesModel("OS", "two"));
        return list;
    }
}
