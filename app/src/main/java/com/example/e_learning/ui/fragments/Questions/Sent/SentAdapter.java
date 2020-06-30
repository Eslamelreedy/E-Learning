package com.example.e_learning.ui.fragments.Questions.Sent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_learning.R;
import com.example.e_learning.pojo.SentModel;

import java.util.ArrayList;

public class SentAdapter extends RecyclerView.Adapter<SentAdapter.sentViewHolder> {
    private ArrayList<SentModel> sentArrayList;

    public SentAdapter(ArrayList <SentModel> sentArrayList) {
        this.sentArrayList = sentArrayList;
    }



    @NonNull
    @Override
    public sentViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType) {
        return new sentViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.sent_question,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull sentViewHolder holder,int position) {
        holder.subject.setText( sentArrayList.get(position).getSubject());
        holder.chapter_number.setText( sentArrayList.get(position).getChapter_number());
        holder.slide_number.setText( sentArrayList.get(position).getSlide_number());
        holder.question_body.setText( sentArrayList.get(position).getQuestion_body());
    }

    @Override
    public int getItemCount() {
        return sentArrayList.size();
    }

    class sentViewHolder extends RecyclerView.ViewHolder {

        TextView subject ;
        TextView chapter_number ;
        TextView slide_number ;
        TextView question_body ;

        public sentViewHolder(@NonNull View itemView) {
            super(itemView);
            subject=itemView.findViewById(R.id.sentQuestionSubject);
            chapter_number=itemView.findViewById(R.id.sentchapterNO);
            slide_number=itemView.findViewById(R.id.sentSlideNO);
            question_body=itemView.findViewById(R.id.sentQuestionBody);
        }
    }

}
