package com.example.e_learning.ui.fragments.Announcement;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_learning.R;
import com.example.e_learning.pojo.AnnouncementModel;

import java.util.ArrayList;

public class AnnouncementAdapter extends RecyclerView.Adapter<AnnouncementAdapter.AnnouncementViewHolder> {

    private ArrayList<AnnouncementModel> AnnouncmentArraylist ;

    public AnnouncementAdapter(ArrayList<AnnouncementModel> announcmentArraylist) {
        AnnouncmentArraylist = announcmentArraylist;

    }



    @NonNull
    @Override
    public AnnouncementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AnnouncementViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.announcement_listrow,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AnnouncementViewHolder holder, int position) {
     holder.department.setText(AnnouncmentArraylist.get(position).getDepartment());
     holder.level.setText(AnnouncmentArraylist.get(position).getLevel());
     holder.section.setText(AnnouncmentArraylist.get(position).getSection());
     holder.subject.setText(AnnouncmentArraylist.get(position).getSubject());
    }

    @Override
    public int getItemCount() {
        return AnnouncmentArraylist.size();
    }


    class AnnouncementViewHolder extends RecyclerView.ViewHolder {
        TextView department;
        TextView section;
        TextView level;
        TextView subject;


        public AnnouncementViewHolder(@NonNull View itemView) {
            super(itemView);

            department = itemView.findViewById(R.id.department);
            section = itemView.findViewById(R.id.Section);
            level = itemView.findViewById(R.id.year);
            subject = itemView.findViewById(R.id.subject);


        }
    }

}
