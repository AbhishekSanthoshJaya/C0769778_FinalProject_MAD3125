package com.aby.c0769778_finalproject_mad3125.ui_fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.aby.c0769778_finalproject_mad3125.R;
import com.aby.c0769778_finalproject_mad3125.model.Bill;
import com.aby.c0769778_finalproject_mad3125.model.Customer;

import butterknife.BindView;
import butterknife.ButterKnife;


public class BillsFragment extends Fragment {


    private TextView txtBillId;
    public BillsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        txtBillId = getView().findViewById(R.id.txtBillId);
        Intent i = getActivity().getIntent();

        Customer customerBills = i.getParcelableExtra("CustomerBills");
        txtBillId.setText(customerBills.getBills().toString());

        return inflater.inflate(R.layout.fragment_bills, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);


//        MainActivity mMainActivity = (MainActivity) getActivity();
//        mMainActivity.hello = "Hi From Fragment";

//        btnSubmit = view.findViewById(R.id.btnSubmit);
//        btnSubmit.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View view)
//            {
//                Toast.makeText(getActivity(), "I am from RED Fragment", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
