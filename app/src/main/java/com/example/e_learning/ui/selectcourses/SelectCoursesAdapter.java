package com.example.e_learning.ui.selectcourses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_learning.R;
import com.example.e_learning.jsondata.AllCoursesData;


import java.util.ArrayList;

public class SelectCoursesAdapter extends RecyclerView.Adapter<SelectCoursesAdapter.SelectCoursesViewHolder> {

    private ArrayList<AllCoursesData> coursesModels = new ArrayList<>();
    private ArrayList<AllCoursesData> Selected = new ArrayList<>();




    @NonNull
    @Override
    public SelectCoursesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.select_courses_row_list, parent, false);
        SelectCoursesViewHolder holder = new SelectCoursesViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull SelectCoursesViewHolder holder, int position) {


        holder.courseName.setText(coursesModels.get(position).getName());
        holder.courseLvl.setText(coursesModels.get(position).getLevel());
        holder.checkBox.setChecked(coursesModels.get(position).isSelected());
        holder.setOnItemClickListener((v, position1) -> {
            CheckBox checkBox = (CheckBox) v;

            if (checkBox.isChecked()) {
                Selected.add(coursesModels.get(position));
            } else {
                Selected.remove(coursesModels.get(position));

            }

        });


    }

    public ArrayList<AllCoursesData> getSelected() {
        return Selected;
    }

    @Override
    public int getItemCount() {
        return coursesModels.size();
    }

    public void setList(ArrayList<AllCoursesData> list)
    {
        this.coursesModels = list ;
        notifyDataSetChanged();
    }

    static class SelectCoursesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView courseName;
        TextView courseLvl;
        CheckBox checkBox;

        ItemClickListener listener;


        public SelectCoursesViewHolder(@NonNull View itemView) {
            super(itemView);


            courseName = itemView.findViewById(R.id.courseName);
            courseLvl = itemView.findViewById(R.id.courseLvl);
            checkBox = itemView.findViewById(R.id.checkBox);
            checkBox.setOnClickListener(this);

        }

        public void setOnItemClickListener(ItemClickListener ic) {
            this.listener = ic;
        }

        @Override
        public void onClick(View v) {
            this.listener.OnItemClick(v, getLayoutPosition());
        }
    }
}
