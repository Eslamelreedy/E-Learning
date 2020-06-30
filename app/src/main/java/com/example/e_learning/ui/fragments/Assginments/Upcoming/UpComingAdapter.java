package com.example.e_learning.ui.fragments.Assginments.Upcoming;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_learning.R;
import com.example.e_learning.pojo.UpComingModel;

import java.util.ArrayList;


public class UpComingAdapter extends RecyclerView.Adapter<UpComingAdapter.UpcomingViewHolder> {
    public UpComingAdapter(ArrayList<UpComingModel> upcomingList) {
        this.upcomingList = upcomingList;
    }

    private ArrayList<UpComingModel> upcomingList;

    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }


    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }


    @NonNull
    @Override
    public UpcomingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.assignment_upcoming, parent, false);
        UpcomingViewHolder holder = new UpcomingViewHolder(v, mListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull UpcomingViewHolder holder, int position) {
        holder.deadline.setText(upcomingList.get(position).getDeadline());
        holder.deadlineDate.setText(upcomingList.get(position).getDeadline_date());
        holder.subjectName.setText(upcomingList.get(position).getSubject_name());
        holder.sheetNumber.setText(upcomingList.get(position).getSheet_number());
        holder.uploadingDate.setText(upcomingList.get(position).getUploading_date());


    }

    @Override
    public int getItemCount() {
        return upcomingList.size();
    }


    public class UpcomingViewHolder extends RecyclerView.ViewHolder {
        TextView deadline;
        TextView deadlineDate;
        TextView subjectName;
        TextView sheetNumber;
        TextView uploadingDate;


        public UpcomingViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            deadline = itemView.findViewById(R.id.deadline);
            deadlineDate = itemView.findViewById(R.id.deadline_date);
            subjectName = itemView.findViewById(R.id.subject_id);
            sheetNumber = itemView.findViewById(R.id.sheet_no_id);
            uploadingDate = itemView.findViewById(R.id.uploadin_date);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }


                }
            });
        }
    }
}
