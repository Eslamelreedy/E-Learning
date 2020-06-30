package com.example.e_learning.ui.fragments.Questions.Answerd;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.e_learning.R;
import com.example.e_learning.pojo.AnswerModel;
import com.example.e_learning.ui.fragments.Questions.Answerd.AnswerAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnsweredFragment extends Fragment {

    public AnsweredFragment() {
        // Required empty public constructor
    }
    RecyclerView answeredRecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_answered, container, false);

        answeredRecyclerView = view.findViewById(R.id.answeredRecyclerView);
        AnswerAdapter adapter = new AnswerAdapter(TestAnsweredQuestions());
        answeredRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        answeredRecyclerView.setAdapter(adapter);
        return view;    }

    private ArrayList<AnswerModel> TestAnsweredQuestions() {
        ArrayList<AnswerModel> answerArrayList = new ArrayList<>();
        answerArrayList.add(new AnswerModel("Operating system", "Chapter2", "Slide 3", "blablablablablablablablablablabla"));
        answerArrayList.add(new AnswerModel("OS", "Chapter 1", "Slide 3", "blablablablablablablablablablabla"));
        answerArrayList.add(new AnswerModel("Math III", "Chapter 1", "Slide 3", "blablablablablablablablablablabla"));
        answerArrayList.add(new AnswerModel("English", "Chapter 1", "Slide 3", "blablablablablablablablablablabla"));
        answerArrayList.add(new AnswerModel("Multimedia", "Chapter 1", "Slide 3", "blablablablablablablablablablabla"));
        answerArrayList.add(new AnswerModel("GIS", "Chapter 1", "Slide 3", "blablablablablablablablablablabla"));

        return answerArrayList;

    }
}
