package com.example.e_learning.ui.fragments.Assginments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.e_learning.R;
import com.example.e_learning.ui.fragments.Assginments.Past.PastFragment;
import com.example.e_learning.ui.fragments.Assginments.Upcoming.UpcomingFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class AssignmentFragment extends Fragment {

    public AssignmentFragment() {
        // Required empty public constructor
    }

    Fragment fragmentpast;
    Fragment fragmentUpComing;
    Button pastBtn;
    Button upComingBtn;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_assignment, container, false);

        pastBtn = view.findViewById(R.id.pastBtn);
        upComingBtn = view.findViewById(R.id.upComingBtn);


        upComingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fragmentUpComing = new UpcomingFragment();
                FragmentManager fragmentManager = getChildFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, fragmentUpComing);
                fragmentTransaction.commit();
                upComingBtn.setBackgroundResource(R.drawable.rounded_button_nbety);
                upComingBtn.setTextColor(getResources().getColor(R.color.white));
                pastBtn.setTextColor(getResources().getColor(R.color.black));
                pastBtn.setBackgroundResource(R.drawable.rounded_button_white);

            }
        });
        pastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentpast = new PastFragment();
                FragmentManager fragmentManager = getChildFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, fragmentpast);
                fragmentTransaction.commit();
                upComingBtn.setBackgroundResource(R.drawable.rounded_button_white);
                pastBtn.setBackgroundResource(R.drawable.rounded_button_nbety);
                pastBtn.setTextColor(getResources().getColor(R.color.white));
                upComingBtn.setTextColor(getResources().getColor(R.color.black));
            }
        });
        return view;
    }

}
