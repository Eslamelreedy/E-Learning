package com.example.e_learning.ui.fragments.Questions.Answerd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_learning.R;
import com.example.e_learning.pojo.AnswerModel;

import java.util.ArrayList;

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.AnsweredViewHolder> {

    private ArrayList <AnswerModel> answerArrayList;

    public AnswerAdapter(ArrayList <AnswerModel> answerArrayList) {
        this.answerArrayList = answerArrayList;
    }


    @NonNull
    @Override
    public AnsweredViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AnsweredViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.answered_question_rowlist,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AnsweredViewHolder holder, int position) {
        holder.AQsubject.setText( answerArrayList.get(position).getAQsubject());
        holder.Achapter_number.setText( answerArrayList.get(position).getChapter_number());
        holder.slide_number.setText( answerArrayList.get(position).getSlide_number());
        holder.question_body.setText( answerArrayList.get(position).getQuestion_body());

    }

    @Override
    public int getItemCount() {
        return answerArrayList.size();
    }

    class AnsweredViewHolder extends RecyclerView.ViewHolder {
        TextView AQsubject ;
        TextView Achapter_number ;
        TextView slide_number ;
        TextView question_body ;

        public AnsweredViewHolder(@NonNull View itemView) {
            super(itemView);
            AQsubject=itemView.findViewById(R.id.answeredQuestionSubject);
            Achapter_number=itemView.findViewById(R.id.answeredchapterNO);
            slide_number=itemView.findViewById(R.id.answeredSlideNO);
            question_body=itemView.findViewById(R.id.answeredQuestionBody);

        }
    }

}
