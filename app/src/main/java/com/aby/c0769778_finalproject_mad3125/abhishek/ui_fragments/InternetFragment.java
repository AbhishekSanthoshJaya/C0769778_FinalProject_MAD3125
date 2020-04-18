package com.aby.c0769778_finalproject_mad3125.abhishek.ui_fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.aby.c0769778_finalproject_mad3125.R;
import com.aby.c0769778_finalproject_mad3125.abhishek.model.Bill;

/**
 * A simple {@link Fragment} subclass.
 */
public class InternetFragment extends Fragment {

    Bill fragBillObj;
    public InternetFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle bundle = new Bundle();
        try
        {
            fragBillObj = (Bill) bundle.getSerializable("billDetailsObj");
        }
        catch (NullPointerException e)
        {
            Toast.makeText(getActivity(), "Sorry boy, still internet null", Toast.LENGTH_SHORT).show();
        }
        return inflater.inflate(R.layout.fragment_internet, container, false);
    }
}
