package com.aby.c0769778_finalproject_mad3125.abhishek.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.aby.c0769778_finalproject_mad3125.R;
import com.aby.c0769778_finalproject_mad3125.abhishek.model.Bill;
import com.aby.c0769778_finalproject_mad3125.abhishek.ui_fragments.HydroBillsFragment;
import com.aby.c0769778_finalproject_mad3125.abhishek.ui_fragments.InternetFragment;
import com.aby.c0769778_finalproject_mad3125.abhishek.ui_fragments.MobileBillsFragment;

public class DetailedBillActivity extends AppCompatActivity {

    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_billsview);

        Intent mIntent = getIntent();
        Bill billObj = (Bill) mIntent.getSerializableExtra("BillObj");

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.hide();

        mFragmentManager = getSupportFragmentManager();

      // if(billObj.getBillId().contains("MB")) {
            mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.add(R.id.container_mob, new MobileBillsFragment());
            mFragmentTransaction.commit();
        //}
       // if(billObj.getBillId().contains("HY"))
       // {
//            mFragmentTransaction = mFragmentManager.beginTransaction();
//            mFragmentTransaction.add(R.id.container_hyd, new HydroBillsFragment());
//            mFragmentTransaction.commit();
       // }
       // if(billObj.getBillId().contains("IN"))
        //{
//            mFragmentTransaction = mFragmentManager.beginTransaction();
//            mFragmentTransaction.add(R.id.container_int, new InternetFragment());
//            mFragmentTransaction.commit();
       // }
    }
}
