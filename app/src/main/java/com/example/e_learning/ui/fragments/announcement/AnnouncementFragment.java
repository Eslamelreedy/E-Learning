package com.example.e_learning.ui.fragments.announcement;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.e_learning.R;
import com.example.e_learning.databinding.FragmentAnnouncementBinding;
import com.example.e_learning.jsondata.AnnouncementsData;
import com.example.e_learning.storage.SharedPrefManger;

import java.util.ArrayList;

public class AnnouncementFragment extends Fragment {


    private FragmentAnnouncementBinding binding;
    private AnnouncementsViewModel announcementsViewModel;

    public AnnouncementFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        announcementsViewModel = new ViewModelProvider(this).get(AnnouncementsViewModel.class);

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_announcement, container, false);
        View view = binding.getRoot();
        AnnouncementAdapter announcementAdapter = new AnnouncementAdapter();
        binding.announcementRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.announcementRecycler.setAdapter(announcementAdapter);
<<<<<<< HEAD

        announcementsViewModel.setStudentId().setValue(SharedPrefManger.getINSTANCE(getActivity()).getUser().getId());
=======
        announcementsViewModel = new ViewModelProvider(requireActivity()).get(AnnouncementsViewModel.class);
        announcementsViewModel.getStudentId().setValue(SharedPrefManger.getINSTANCE(getActivity()).getUser().getId());
>>>>>>> origin/develop
        announcementsViewModel.getAnnouncements();
        announcementsViewModel.getResponse().observe(getViewLifecycleOwner(), announcementsModel -> {

            if (announcementsModel.getStatus()) {
<<<<<<< HEAD
                if (announcementsModel.getData() != null)
                {
=======
                if (announcementsModel.getData() != null) {
>>>>>>> origin/develop
                    announcementAdapter.setList((ArrayList<AnnouncementsData>) announcementsModel.getData());
                } else
                    Toast.makeText(getActivity(), "no data ", Toast.LENGTH_SHORT).show();
<<<<<<< HEAD
=======


>>>>>>> origin/develop
            } else if (!announcementsModel.getStatus()) {
                Toast.makeText(getContext(), announcementsModel.getError(), Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), "false", Toast.LENGTH_SHORT).show();
            }

        });
        return view;
    }

<<<<<<< HEAD
=======
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

>>>>>>> origin/develop

}
