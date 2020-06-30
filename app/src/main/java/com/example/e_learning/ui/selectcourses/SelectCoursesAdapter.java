package com.example.e_learning.ui.selectcourses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_learning.R;
import com.example.e_learning.pojo.SelectCoursesModel;

import java.util.ArrayList;

public class SelectCoursesAdapter extends RecyclerView.Adapter<SelectCoursesAdapter.SelectCoursesViewHolder> {

    private ArrayList<SelectCoursesModel> coursesModels ;
    private ArrayList<SelectCoursesModel> Selected = new ArrayList<>();





    public SelectCoursesAdapter(ArrayList<SelectCoursesModel> coursesModels) {
        this.coursesModels = coursesModels;
    }

    @NonNull
    @Override
    public SelectCoursesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.select_courses_row_list,parent,false);
        SelectCoursesViewHolder holder = new SelectCoursesViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull SelectCoursesViewHolder holder, int position) {


        holder.courseName.setText(coursesModels.get(position).getCourseName());
        holder.courseLvl.setText(coursesModels.get(position).getCourseLvl());
        holder.checkBox.setChecked(coursesModels.get(position).isSelected());
        holder.setOnItemClickListener((v, position1) -> {
            CheckBox checkBox = (CheckBox) v;

            if (checkBox.isChecked())
            {
                Selected.add(coursesModels.get(position));
            }
            else
            {
                Selected.remove(coursesModels.get(position));

            }

        });



    }

    public ArrayList<SelectCoursesModel> getSelected() {
        return Selected;
    }

    @Override
    public int getItemCount() {
        return coursesModels.size();
    }

    static class SelectCoursesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView courseName ;
        TextView courseLvl ;
        CheckBox checkBox;

        ItemClickListener listener;


        public SelectCoursesViewHolder(@NonNull View itemView) {
            super(itemView);


           courseName = itemView.findViewById(R.id.courseName);
           courseLvl = itemView.findViewById(R.id.courseLvl);
           checkBox = itemView.findViewById(R.id.checkBox);
           checkBox.setOnClickListener(this);

        }

        public void setOnItemClickListener (ItemClickListener ic)
        {
            this.listener =ic;
        }

        @Override
        public void onClick(View v) {
            this.listener.OnItemClick(v,getLayoutPosition());
        }
    }
}
