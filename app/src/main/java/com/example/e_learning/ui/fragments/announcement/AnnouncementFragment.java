package com.example.e_learning.ui.fragments.announcement;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.e_learning.R;
import com.example.e_learning.databinding.FragmentAnnouncementBinding;
import com.example.e_learning.jsondata.AnnouncementsData;
import com.example.e_learning.storage.SharedPrefManger;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnnouncementFragment extends Fragment {


    private FragmentAnnouncementBinding binding;
    private AnnouncementsViewModel announcementsViewModel;

    public AnnouncementFragment() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_announcement, container, false);
        View view = binding.getRoot();
        return view;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AnnouncementAdapter announcementAdapter = new AnnouncementAdapter();
        binding.announcementRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.announcementRecycler.setAdapter(announcementAdapter);
        announcementsViewModel.getStudentId().setValue(SharedPrefManger.getINSTANCE(this.getActivity()).getUser().getId());

        announcementsViewModel = new ViewModelProvider(requireActivity()).get(AnnouncementsViewModel.class);

        announcementsViewModel.getAnnouncements();
        announcementsViewModel.announcementsModelMutableLiveData.observe(getViewLifecycleOwner(), announcementsModel -> {
            if (announcementsModel.getStatus()) {
                announcementAdapter.setList((ArrayList<AnnouncementsData>) announcementsModel.getData());

            } else if (!announcementsModel.getStatus()) {
                Toast.makeText(getContext(), announcementsModel.getError(), Toast.LENGTH_SHORT).show();
            }
        });


    }


}
