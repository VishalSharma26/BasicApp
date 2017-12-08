package com.example.u.realapp.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.u.realapp.R;

/**
 * Created by U on 4/29/2017.
 */

public class MainFragmentClass extends AppCompatActivity {
    boolean one = true;
    FragmentOne fragmentOne;
    FragmentTwo fragmentTwo;
    FragmentManager manager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_fragment_class);
        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();
        manager = getSupportFragmentManager();
    }

    public void OnChangeFragment(View view) {

        if (one){
            manager.beginTransaction().replace(R.id.fragment_container,fragmentOne).commit();
            one = false;
        } else{
            manager.beginTransaction().replace(R.id.fragment_container,fragmentTwo).commit();
            one = true;
        }

    }
}
