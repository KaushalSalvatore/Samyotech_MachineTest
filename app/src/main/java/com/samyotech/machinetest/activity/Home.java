package com.samyotech.machinetest.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.samyotech.machinetest.R;
import com.samyotech.machinetest.fragment.Heart;
import com.samyotech.machinetest.fragment.Search;
import com.samyotech.machinetest.fragment.Userhome;
import com.samyotech.machinetest.fragment.Userprofile;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
      //  navigation.disableShiftMode(navigation);

        loadFragment(new Search());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.search:
                    fragment = new Search();
                    loadFragment(fragment);
                    return true;
                case R.id.home:
                    fragment = new Userhome();
                    loadFragment(fragment);
                    return true;
                case R.id.heart:
                    fragment = new Heart();
                    loadFragment(fragment);
                    return true;
                case R.id.user:
                    fragment = new Userprofile();
                    loadFragment(fragment);
                    return true;
            }

            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}