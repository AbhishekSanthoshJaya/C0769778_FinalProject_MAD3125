package com.aby.c0769778_finalproject_mad3125.abhishek.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aby.c0769778_finalproject_mad3125.R;
import com.aby.c0769778_finalproject_mad3125.abhishek.adapters.BillsAdapter;
import com.aby.c0769778_finalproject_mad3125.abhishek.model.Bill;
import com.aby.c0769778_finalproject_mad3125.abhishek.model.Customer;
import com.aby.c0769778_finalproject_mad3125.abhishek.util.HelperMethods;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ShowBillDetailsActivity extends AppCompatActivity {

    private RecyclerView rvBillsList;
    private ArrayList<Bill> billsArrayListDetail;
    private BillsAdapter billsAdapter;
    private ImageView imgAddButton;
    private TextView txtTotalAmountValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bill_details2);

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setTitle("YOUR BILLS");

        Intent mIntent = getIntent();
        Customer customerObj = mIntent.getParcelableExtra("CustomerBills");
        billsArrayListDetail = customerObj.getBills();

        txtTotalAmountValue = findViewById(R.id.txtTotalAmountValue);

        if(!billsArrayListDetail.isEmpty())
            {
                txtTotalAmountValue.setText("YOUR TOTAL IS " + HelperMethods.getInstance().doubleFormatter(customerObj.getTotalAmount()));
            }
        else
            {
                txtTotalAmountValue.setText("NO BILLS TO DISPLAY");
            }

        rvBillsList = findViewById(R.id.rvBillsList);
        billsAdapter = new BillsAdapter(billsArrayListDetail);

        RecyclerView.LayoutManager mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        billsAdapter.notifyDataSetChanged();
        rvBillsList.setLayoutManager(mLinearLayoutManager);
        rvBillsList.setAdapter(billsAdapter);

        imgAddButton = findViewById(R.id.imgAddBill);
        imgAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(ShowBillDetailsActivity.this, AddNewBillActivity.class);
                mIntent.putExtra("CustomerBills2", customerObj);
                startActivity(mIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_customerlist, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnuAddCustomer:
                Intent addBill = new Intent(ShowBillDetailsActivity.this, AddNewBillActivity.class);
                startActivity(addBill);
                break;
            case R.id.mnuLogout:
                Intent logoutIntent = new Intent(ShowBillDetailsActivity.this, LoginActivity.class);
                startActivity(logoutIntent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        return;
    }
}
