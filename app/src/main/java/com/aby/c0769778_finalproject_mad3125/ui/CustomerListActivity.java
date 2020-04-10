package com.aby.c0769778_finalproject_mad3125.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.aby.c0769778_finalproject_mad3125.R;
import com.aby.c0769778_finalproject_mad3125.adapters.CustomerAdapter;
import com.aby.c0769778_finalproject_mad3125.model.Customer;
import com.aby.c0769778_finalproject_mad3125.util.DataRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class CustomerListActivity extends AppCompatActivity {
    private ImageButton imgBtnAddCustomer;
    private RecyclerView rvCustomerList;
    private ArrayList customerArrayList;
    private ArrayList tempCustomerArrayList;
    private CustomerAdapter customerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        imgBtnAddCustomer = findViewById(R.id.imgBtnAddCustomer);

        rvCustomerList = findViewById(R.id.rvCustomerList);

        loadCustomers();
        customerAdapter = new CustomerAdapter(customerArrayList);
        RecyclerView.LayoutManager mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rvCustomerList.setLayoutManager(mLinearLayoutManager);
        rvCustomerList.setAdapter(customerAdapter);

        imgBtnAddCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code to add a customer
                DataRepository.getInstance().makeToast("Success", CustomerListActivity.this);
            }
        });
    }

    private void loadCustomers()
    {
        DataRepository.getInstance().loadData();
        customerArrayList = new ArrayList();
        HashMap<String, Customer> customerHashMap = DataRepository.getInstance().getCustomerMap();
        Collection<Customer> demoValues = customerHashMap.values();
        tempCustomerArrayList = new ArrayList<>(demoValues);
        for(int i =0; i<tempCustomerArrayList.size(); i++)
        {
            customerArrayList.add(tempCustomerArrayList.get(i));
        }
    }
}
