package com.example.e_learning.ui.fragments.Assginments.Past;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_learning.R;
import com.example.e_learning.pojo.PastModel;

import java.util.ArrayList;

public class PastAdapter extends RecyclerView.Adapter<PastAdapter.PastViewHolder> {
    PastAdapter(ArrayList<PastModel> pastArrayList) {
        this.pastArrayList = pastArrayList;
    }

    private ArrayList<PastModel> pastArrayList;

    @NonNull
    @Override
    public PastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PastViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.past_assignment, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull PastViewHolder holder, int position) {

        holder.deliverd.setText(pastArrayList.get(position).getDeliverd());
        holder.subjectName.setText(pastArrayList.get(position).getSubject_name());
        holder.sheetNumber.setText(pastArrayList.get(position).getSheet_number());
        holder.grade.setText(pastArrayList.get(position).getGrade());

    }

    @Override
    public int getItemCount() {
        return pastArrayList.size();
    }

    class PastViewHolder extends RecyclerView.ViewHolder {
        TextView deliverd;
        TextView subjectName;
        TextView sheetNumber;
        TextView grade;

        public PastViewHolder(@NonNull View itemView) {
            super(itemView);
            deliverd = itemView.findViewById(R.id.deliverd);
            subjectName = itemView.findViewById(R.id.subjectId);
            sheetNumber = itemView.findViewById(R.id.sheetNo_id);
            grade = itemView.findViewById(R.id.grade);
        }
    }
}
