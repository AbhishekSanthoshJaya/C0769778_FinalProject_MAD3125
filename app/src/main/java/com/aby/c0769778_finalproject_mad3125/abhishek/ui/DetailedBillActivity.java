package com.aby.c0769778_finalproject_mad3125.abhishek.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.aby.c0769778_finalproject_mad3125.R;
import com.aby.c0769778_finalproject_mad3125.abhishek.model.Bill;
import com.aby.c0769778_finalproject_mad3125.abhishek.ui_fragments.HydroBillsFragment;
import com.aby.c0769778_finalproject_mad3125.abhishek.ui_fragments.InternetFragment;
import com.aby.c0769778_finalproject_mad3125.abhishek.ui_fragments.MobileBillsFragment;

public class DetailedBillActivity extends AppCompatActivity {

    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    Bill billObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_billsview);

        Intent mIntent = getIntent();
        billObj = (Bill) mIntent.getSerializableExtra("BillObj");

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.hide();

        TextView txtHeading = findViewById(R.id.txtHeading);
        txtHeading.setText("DETAILED BILL VIEW");

           if(billObj.getBillId().contains("MB"))
                {
                    MobileBillsFragment mFragment = new MobileBillsFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("billDetailsObj", billObj);
                    mFragment.setArguments(bundle);
                    mFragmentManager = getSupportFragmentManager();
                    mFragmentTransaction = mFragmentManager.beginTransaction();
                    mFragmentTransaction.replace(R.id.container_mob, mFragment);
                    mFragmentTransaction.commit();
                }

            if(billObj.getBillId().contains("HY"))
                {
                    HydroBillsFragment mFragment = new HydroBillsFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("billDetailsObj2", billObj);
                    mFragment.setArguments(bundle);
                    mFragmentManager = getSupportFragmentManager();
                    mFragmentTransaction = mFragmentManager.beginTransaction();
                    mFragmentTransaction.replace(R.id.container_hyd, mFragment);
                    mFragmentTransaction.commit();
                }

            if(billObj.getBillId().contains("IN"))
                {
                    InternetFragment mFragment = new InternetFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("billDetailsObj3", billObj);
                    mFragment.setArguments(bundle);
                    mFragmentManager = getSupportFragmentManager();
                    mFragmentTransaction = mFragmentManager.beginTransaction();
                    mFragmentTransaction.replace(R.id.container_int, mFragment);
                    mFragmentTransaction.commit();
                }
    }
}
