package com.example.e_learning.ui.fragments.Courses;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.e_learning.R;
import com.example.e_learning.pojo.CourseModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoursesFragment extends Fragment {

    public CoursesFragment() {
        // Required empty public constructor
    }
    ListView listView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_courses, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = view.findViewById(R.id.listViewcourses);
        ArrayList<CourseModel> arrayList = new ArrayList<>();
        arrayList.add(new CourseModel("OOP", "Dr Ahmed", "LVl 3"));
        arrayList.add(new CourseModel("DataBase", "Dr Waleed", "LVl 2"));
        arrayList.add(new CourseModel("OS", "Dr Shereen", "LVl1"));
        arrayList.add(new CourseModel("Security", "Dr Ahmed", "LVl 4"));
        arrayList.add(new CourseModel("OOP", "Dr Ahmed", "LVl 4"));

        CoursesAdapter myAdapter = new CoursesAdapter(arrayList, getContext());

        listView.setAdapter(myAdapter);


        listView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return (event.getAction() == MotionEvent.ACTION_MOVE);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent= new Intent(getContext(),CourseContent.class);
                    startActivity(intent);
                }
                if (i == 1) {
                    Toast.makeText(getContext(), "2 Item", Toast.LENGTH_SHORT).show();
                }
                if (i == 2) {
                    Toast.makeText(getContext(), "3 Item", Toast.LENGTH_SHORT).show();
                }
                if (i == 3) {
                    Toast.makeText(getContext(), "4 Item", Toast.LENGTH_SHORT).show();
                }
                if (i == 4) {
                    Toast.makeText(getContext(), "5 Item", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
