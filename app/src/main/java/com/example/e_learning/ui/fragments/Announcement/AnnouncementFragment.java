package com.example.e_learning.ui.fragments.Announcement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.e_learning.R;
import com.example.e_learning.pojo.AnnouncementModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnnouncementFragment extends Fragment {
    RecyclerView announcementRecycler;


    public AnnouncementFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_announcement, container, false);
        announcementRecycler = view.findViewById(R.id.announcementRecycler);
        AnnouncementAdapter announcementAdapter = new AnnouncementAdapter(TestAnnouncment());
        announcementRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        announcementRecycler.setAdapter(announcementAdapter);

        return view;
    }

    private ArrayList<AnnouncementModel> TestAnnouncment() {
        ArrayList<AnnouncementModel> AnnouncementArrayList = new ArrayList<>();
        AnnouncementArrayList.add(new AnnouncementModel("CS Department", "Level 3", "Section A", "consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."));
        AnnouncementArrayList.add(new AnnouncementModel("IS Department", "Level 4", "Section B", "consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."));
        AnnouncementArrayList.add(new AnnouncementModel("General Department", "Level 1", "Section C", "consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."));
        AnnouncementArrayList.add(new AnnouncementModel("CS Department", "Level 3", "Section B", "consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."));
        AnnouncementArrayList.add(new AnnouncementModel("CS Department", "Level 4", "Section D", "consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."));
        AnnouncementArrayList.add(new AnnouncementModel("CS Department", "Level 4", "Section F", "consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."));
        AnnouncementArrayList.add(new AnnouncementModel("CS Department", "Level 2", "Section H", "consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."));


        return AnnouncementArrayList;

    }
}
