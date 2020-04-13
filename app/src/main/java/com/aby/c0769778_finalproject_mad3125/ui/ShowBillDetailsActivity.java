package com.aby.c0769778_finalproject_mad3125.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.aby.c0769778_finalproject_mad3125.R;
import com.aby.c0769778_finalproject_mad3125.model.Bill;
import com.aby.c0769778_finalproject_mad3125.model.Customer;
import com.aby.c0769778_finalproject_mad3125.ui_fragments.BillsFragment;
import com.aby.c0769778_finalproject_mad3125.util.HelperMethods;

import java.util.ArrayList;

public class ShowBillDetailsActivity extends AppCompatActivity {

    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    private TextView txtTotalAmount;
    private ImageView imgAddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_details);

        Intent mIntent = getIntent();
        Customer customerObj = mIntent.getParcelableExtra("CustomerBills");

        ArrayList<Bill> bills = customerObj.getBills();

        txtTotalAmount = findViewById(R.id.txtTotalAmount);
        imgAddButton = findViewById(R.id.imgAddBill);
        imgAddButton.setImageResource(R.drawable.addbillsicon);

        imgAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(ShowBillDetailsActivity.this, AddNewBillActivity.class);
                startActivity(mIntent);
            }
        });

        txtTotalAmount.setText(HelperMethods.getInstance().doubleFormatter(customerObj.getTotalAmount()));

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.hide();

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.add(R.id.container, new BillsFragment());
        mFragmentTransaction.commit();

//        mFragmentTransaction = mFragmentManager.beginTransaction();
//        mFragmentTransaction.add(R.id.container2, new BillsFragment());
//        mFragmentTransaction.commit();
    }
}
