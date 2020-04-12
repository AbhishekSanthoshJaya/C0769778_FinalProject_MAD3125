package com.aby.c0769778_finalproject_mad3125.ui_fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aby.c0769778_finalproject_mad3125.R;
import com.aby.c0769778_finalproject_mad3125.model.Bill;
import com.aby.c0769778_finalproject_mad3125.model.Customer;
import com.aby.c0769778_finalproject_mad3125.util.DataRepository;
import com.aby.c0769778_finalproject_mad3125.util.HelperMethods;

import java.util.ArrayList;

import butterknife.ButterKnife;


public class BillsFragment extends Fragment {

    private TextView txtBillId;
    private TextView txtBillDate;
    private TextView txtBillAmount;
    private ImageView imgBillType;
    double totalAmount;

    public BillsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bills, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        txtBillId = getView().findViewById(R.id.txtBillId);
        txtBillDate = getView().findViewById(R.id.txtBillDate);
        txtBillAmount = getView().findViewById(R.id.txtBillAmount);
        imgBillType = getView().findViewById(R.id.imgBillType);

        Intent mIntent = getActivity().getIntent();
        Customer customerObj = mIntent.getParcelableExtra("CustomerBills");

        // cust = (Customer) getActivity().getIntent().getExtras().getSerializable("billsKey");
        ArrayList<Bill> bills = customerObj.getBills();
        for(int j = 0; j< bills.size(); j++)
        {
            totalAmount += bills.get(j).getBillTotal();
        }

       // Log.d("Tag", String.valueOf(totalAmount));

        for(int i =0; i <bills.size(); i++)
        {
            if(bills.get(i).getBillId().contains("MB"))
            {
                txtBillId.setText(bills.get(i).getBillId());
                imgBillType.setImageResource(R.drawable.mobileicon);
                txtBillAmount.setText(HelperMethods.getInstance().doubleFormatter(bills.get(i).billCalculate()));
                txtBillDate.setText(bills.get(i).getBillDate().toString());
            }

            if(bills.get(i).getBillId().contains("HY"))
            {
                txtBillId.setText(bills.get(i).getBillId());
                imgBillType.setImageResource(R.drawable.watericon);
                txtBillAmount.setText(HelperMethods.getInstance().doubleFormatter(bills.get(i).billCalculate()));
                txtBillDate.setText(bills.get(i).getBillDate().toString());
            }

            if(bills.get(i).getBillId().contains("IN"))
            {
                txtBillId.setText(bills.get(i).getBillId());
                imgBillType.setImageResource(R.drawable.mobileicon);
                txtBillAmount.setText(HelperMethods.getInstance().doubleFormatter(bills.get(i).billCalculate()));
                txtBillDate.setText(bills.get(i).getBillDate().toString());
            }
        }
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
