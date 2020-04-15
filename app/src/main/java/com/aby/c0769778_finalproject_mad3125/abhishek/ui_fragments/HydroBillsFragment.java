package com.aby.c0769778_finalproject_mad3125.abhishek.ui_fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aby.c0769778_finalproject_mad3125.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HydroBillsFragment extends Fragment {

    public HydroBillsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hydro_bills, container, false);
    }
}
