package com.example.e_learning.ui.fragments.Assginments.Past;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.e_learning.R;
import com.example.e_learning.pojo.PastModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PastFragment extends Fragment {

    public PastFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_past, container, false);
        recyclerView = view.findViewById(R.id.PastRecyclerView);
        PastAdapter adapter = new PastAdapter(TestAssignments());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        return view;
    }

    private ArrayList<PastModel> TestAssignments() {
        ArrayList<PastModel> pastArrayList = new ArrayList<>();
        pastArrayList.add(new PastModel("Deliverd", "OOP", "Sheet2", "8/10"));
        pastArrayList.add(new PastModel("Deliverd", "OOP", "Sheet2", "8/10"));
        pastArrayList.add(new PastModel("Deliverd", "OOP", "Sheet2", "8/10"));
        pastArrayList.add(new PastModel("Deliverd", "OOP", "Sheet2", "8/10"));
        pastArrayList.add(new PastModel("Deliverd", "OOP", "Sheet2", "8/10"));
        pastArrayList.add(new PastModel("Deliverd", "OOP", "Sheet2", "8/10"));

        return pastArrayList;

    }


}
