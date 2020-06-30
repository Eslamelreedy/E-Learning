package com.example.e_learning.ui.fragments.Questions.Sent;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.e_learning.R;
import com.example.e_learning.pojo.SentModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public  class SentFragment extends Fragment {
    public SentFragment() {
    }

    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_sent, container, false);
        recyclerView = view.findViewById(R.id.sentRecyclerView);
        SentAdapter adapter = new SentAdapter(TestQuestions());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        return view;
    }

    private ArrayList<SentModel> TestQuestions() {
        ArrayList<SentModel> sentArrayList = new ArrayList<>();
        sentArrayList.add(new SentModel("Operating system", "Chapter2", "Slide 3", "blablablablablablablablablablabla"));
        sentArrayList.add(new SentModel("OS", "Chapter 1", "Slide 3", "blablablablablablablablablablabla"));
        sentArrayList.add(new SentModel("Math III", "Chapter 1", "Slide 3", "blablablablablablablablablablabla"));
        sentArrayList.add(new SentModel("English", "Chapter 1", "Slide 3", "blablablablablablablablablablabla"));
        sentArrayList.add(new SentModel("Multimedia", "Chapter 1", "Slide 3", "blablablablablablablablablablabla"));
        sentArrayList.add(new SentModel("GIS", "Chapter 1", "Slide 3", "blablablablablablablablablablabla"));

        return sentArrayList;
    }
}