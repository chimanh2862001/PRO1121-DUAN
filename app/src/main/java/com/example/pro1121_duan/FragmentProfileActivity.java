package com.example.pro1121_duan;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FragmentProfileActivity extends Fragment {


    Toolbar toolbar;

    public FragmentProfileActivity() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_activity, container, false);

        toolbar = view.findViewById(R.id.toolbarProfile);
        toolbar.setTitle("Profile");

        return view;
    }
}