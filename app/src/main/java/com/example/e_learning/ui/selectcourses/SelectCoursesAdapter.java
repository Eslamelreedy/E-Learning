package com.example.e_learning.ui.selectcourses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_learning.R;
import com.example.e_learning.jsondata.AllCoursesData;


import java.util.ArrayList;

public class SelectCoursesAdapter extends RecyclerView.Adapter<SelectCoursesAdapter.SelectCoursesViewHolder> {

    private ArrayList<AllCoursesData> coursesModels = new ArrayList<>();
    private ArrayList<AllCoursesData> Selected = new ArrayList<>();
    private ItemClickListener listener;


    public interface ItemClickListener {
        void OnItemClick(int position);

        void OnAddCourseClick(int position);

    }

    void setOnItemClickListener(ItemClickListener ic) {
        listener = ic;

    }

    @NonNull
    @Override
    public SelectCoursesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.select_courses_row_list, parent, false);
        SelectCoursesViewHolder holder = new SelectCoursesViewHolder(view, listener);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull SelectCoursesViewHolder holder, int position) {


        holder.courseName.setText(coursesModels.get(position).getName());
        holder.courseLvl.setText("Level " + coursesModels.get(position).getLevel());


    }

    public ArrayList<AllCoursesData> getSelected() {
        return Selected;
    }

    @Override
    public int getItemCount() {
        return coursesModels.size();
    }

    void setList(ArrayList<AllCoursesData> list) {
        this.coursesModels = list;
        notifyDataSetChanged();
    }

    static class SelectCoursesViewHolder extends RecyclerView.ViewHolder {

        TextView courseName;
        TextView courseLvl;
        Button addCourse;


        public SelectCoursesViewHolder(@NonNull View itemView, ItemClickListener listener) {
            super(itemView);


            courseName = itemView.findViewById(R.id.courseName);
            courseLvl = itemView.findViewById(R.id.courseLvl);
            addCourse = itemView.findViewById(R.id.addCourseBtn);
            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.OnItemClick(position);
                    }
                }
            });
            addCourse.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.OnAddCourseClick(position);
                    }
                }
            });


        }
    }
}
