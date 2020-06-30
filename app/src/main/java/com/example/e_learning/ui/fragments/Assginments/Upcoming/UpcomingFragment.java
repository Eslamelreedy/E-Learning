package com.example.e_learning.ui.fragments.Assginments.Upcoming;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.e_learning.R;
import com.example.e_learning.pojo.UpComingModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpcomingFragment extends Fragment {

    public UpcomingFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_upcoming, container, false);

        recyclerView = view.findViewById(R.id.UpcomingRecycler);
        UpComingAdapter adapter = new UpComingAdapter(TestAssignments());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(position -> {
            String name =TestAssignments().get(position).getSubject_name();
            Toast.makeText(getContext(), name, Toast.LENGTH_SHORT).show();

        });



        return view;

    }
    private ArrayList<UpComingModel> TestAssignments ()
    {
        ArrayList<UpComingModel> upComingArrayList = new ArrayList<>();
        upComingArrayList.add(new UpComingModel("Deadline", "20/5/2020", "DBM", "sheet 2", "10/2/2020"));
        upComingArrayList.add(new UpComingModel("Deadline", "20/5/2020", "Datbase", "sheet 2", "10/2/2020"));
        upComingArrayList.add(new UpComingModel("Deadline", "20/5/2020", "sec", "sheet 2", "10/2/2020"));
        upComingArrayList.add(new UpComingModel("Deadline", "20/5/2020", "DBM", "sheet 2", "10/2/2020"));
        upComingArrayList.add(new UpComingModel("Deadline", "20/5/2020", "DBM", "sheet 2", "10/2/2020"));
        upComingArrayList.add(new UpComingModel("Deadline", "20/5/2020", "DBM", "sheet 2", "10/2/2020"));
        return upComingArrayList;

    }


}