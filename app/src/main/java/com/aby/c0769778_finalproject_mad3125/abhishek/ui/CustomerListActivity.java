package com.aby.c0769778_finalproject_mad3125.abhishek.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aby.c0769778_finalproject_mad3125.R;
import com.aby.c0769778_finalproject_mad3125.abhishek.adapters.CustomerAdapter;
import com.aby.c0769778_finalproject_mad3125.abhishek.model.Customer;
import com.aby.c0769778_finalproject_mad3125.abhishek.util.DataRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomerListActivity extends AppCompatActivity {

    private RecyclerView rvCustomerList;
    private ArrayList customerArrayList;
    private ArrayList tempCustomerArrayList;
    private CustomerAdapter customerAdapter;
    private ImageView barAddCustomer;
    private ImageView barLogout;

    @BindView(R.id.imgBtnAddCustomer) ImageButton ImgBtnAddCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        ButterKnife.bind(this);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        View view = getSupportActionBar().getCustomView();

        barAddCustomer = view.findViewById(R.id.barAddCustomer);
        barLogout = view.findViewById(R.id.barLogout);

        rvCustomerList = findViewById(R.id.rvCustomerList);

        barAddCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(CustomerListActivity.this, AddCustomerActivity.class);
                startActivity(mIntent);
            }
        });

        barLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(CustomerListActivity.this, LoginActivity.class);
                startActivity(mIntent);
            }
        });
        loadCustomers();
        customerAdapter = new CustomerAdapter(customerArrayList);
        RecyclerView.LayoutManager mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rvCustomerList.setLayoutManager(mLinearLayoutManager);
        rvCustomerList.setAdapter(customerAdapter);

        ImgBtnAddCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(CustomerListActivity.this, AddCustomerActivity.class);
                startActivity(mIntent);
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_customerlist, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.mnuAddCustomer:
//                Intent addCustomer = new Intent(CustomerListActivity.this, AddCustomerActivity.class);
//                startActivity(addCustomer);
//            case R.id.mnuLogout:
//                Intent logoutIntent = new Intent(CustomerListActivity.this, LoginActivity.class);
//                startActivity(logoutIntent);
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    private void loadCustomers()
    {
        DataRepository.getInstance().loadData();
        customerArrayList = new ArrayList();
        HashMap<String, Customer> customerHashMap = DataRepository.getInstance().getCustomerMap();
        Collection<Customer> demoValues = customerHashMap.values();
        tempCustomerArrayList = new ArrayList<>(demoValues);
        customerArrayList.addAll(tempCustomerArrayList);
    }
}
