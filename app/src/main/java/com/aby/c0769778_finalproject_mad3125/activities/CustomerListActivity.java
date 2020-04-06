package com.aby.c0769778_finalproject_mad3125.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.aby.c0769778_finalproject_mad3125.R;
import com.aby.c0769778_finalproject_mad3125.util.DataRepository;

public class CustomerListActivity extends AppCompatActivity {
    private Button btnLogout;
    private ImageButton imgBtnAddCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        btnLogout = findViewById(R.id.btnLogOut);
        imgBtnAddCustomer = findViewById(R.id.imgBtnAddCustomer);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(CustomerListActivity.this, LoginActivity.class);
                startActivity(mIntent);
            }
        });
        imgBtnAddCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code to add a customer
                DataRepository.getInstance().makeToast("Success", CustomerListActivity.this);
            }
        });
    }
}
