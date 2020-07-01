package com.example.e_learning.ui.drawer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import com.example.e_learning.R;
import com.example.e_learning.storage.SharedPrefManger;
import com.example.e_learning.ui.fragments.Announcement.AnnouncementFragment;
import com.example.e_learning.ui.fragments.Assginments.AssignmentFragment;
import com.example.e_learning.ui.fragments.Courses.CoursesFragment;
import com.example.e_learning.ui.fragments.Questions.QuestionsFragment;
import com.example.e_learning.ui.fragments.SettingFragment;
import com.example.e_learning.ui.login.LoginActivity;
import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Drawer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.navigationView)
    NavigationView navigationView;
    @BindView(R.id.drawer)
    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;


    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.drawerOpen, R.string.drawerClose);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        AnnouncementFragment fragment = new AnnouncementFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.rel_layout, fragment, "Home");
        fragmentTransaction.commit();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.announcement) {
            AnnouncementFragment fragment = new AnnouncementFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.rel_layout, fragment, "Announcement");
            fragmentTransaction.commit();
        } else if (id == R.id.questions) {
            QuestionsFragment fragment = new QuestionsFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.rel_layout, fragment, "Questions");
            fragmentTransaction.commit();
        } else if (id == R.id.courses) {
            CoursesFragment fragment = new CoursesFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.rel_layout, fragment, "Courses");
            fragmentTransaction.commit();
        } else if (id == R.id.assignment) {
            AssignmentFragment fragment = new AssignmentFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.rel_layout, fragment, "Assignments");
            fragmentTransaction.commit();
        } else if (id == R.id.setting) {
            SettingFragment fragment = new SettingFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.rel_layout, fragment, "Setting");
            fragmentTransaction.commit();
        } else if (id == R.id.logout) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            SharedPrefManger.getINSTANCE(this).clear();

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
