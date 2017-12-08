package com.example.u.realapp.MenuInflater;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.example.u.realapp.R;

/**
 * Created by U on 10/27/2016.
 */
public class Setting extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.setting);
    }
}
