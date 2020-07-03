package com.example.e_learning.ui.fragments.announcement;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_learning.R;
import com.example.e_learning.jsondata.AnnouncementsData;

import java.util.ArrayList;

public class AnnouncementAdapter extends RecyclerView.Adapter<AnnouncementAdapter.AnnouncementViewHolder> {



    private ArrayList<AnnouncementsData> AnnouncementArrayList;

    void setList(ArrayList<AnnouncementsData> list) {
        this.AnnouncementArrayList = list;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public AnnouncementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AnnouncementViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.announcement_listrow, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AnnouncementViewHolder holder, int position) {
        holder.announcementNo.setText(AnnouncementArrayList.get(position).getId());
        holder.subject.setText(AnnouncementArrayList.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return AnnouncementArrayList.size();
    }


    static class AnnouncementViewHolder extends RecyclerView.ViewHolder {
        TextView announcementNo;
        TextView subject;


        AnnouncementViewHolder(@NonNull View itemView) {
            super(itemView);

           announcementNo = itemView.findViewById(R.id.AnnouncementNo);
            subject = itemView.findViewById(R.id.subject);


        }
    }

}
