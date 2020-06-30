package com.example.e_learning.ui.fragments.Questions;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.e_learning.R;
import com.example.e_learning.ui.fragments.Questions.Answerd.AnsweredFragment;
import com.example.e_learning.ui.fragments.Questions.Sent.SentFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionsFragment extends Fragment {

    public QuestionsFragment() {
    }

    Fragment fragment;

    Button sentBtn;
    Button answeredBtn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_questions, container, false);

        sentBtn = view.findViewById(R.id.sentBtn);
        answeredBtn = view.findViewById(R.id.answeredBtn);


        sentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fragment = new SentFragment();

                FragmentManager fragmentManager = getChildFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment2, fragment);
                fragmentTransaction.commit();
                sentBtn.setBackgroundResource(R.drawable.rounded_button_nbety);
                sentBtn.setTextColor(getResources().getColor(R.color.white));
                answeredBtn.setTextColor(getResources().getColor(R.color.black));
                answeredBtn.setBackgroundResource(R.drawable.rounded_button_white);

            }
        });
        answeredBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new AnsweredFragment();
                FragmentManager fragmentManager = getChildFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment2, fragment);
                fragmentTransaction.commit();
                sentBtn.setBackgroundResource(R.drawable.rounded_button_white);
                answeredBtn.setBackgroundResource(R.drawable.rounded_button_nbety);
                answeredBtn.setTextColor(getResources().getColor(R.color.white));
                sentBtn.setTextColor(getResources().getColor(R.color.black));
            }
        });
        return view;
    }


}
