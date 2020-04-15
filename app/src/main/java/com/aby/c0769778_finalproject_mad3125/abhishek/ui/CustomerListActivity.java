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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomerListActivity extends AppCompatActivity {

    private RecyclerView rvCustomerList;
    private ArrayList customerArrayList;
    private ArrayList tempCustomerArrayList;
    private ArrayList<Customer> tempCustomerListArrayList;
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
        //readJson();
        //customerAdapter = new CustomerAdapter(DataRepository.getInstance().getCustomerDataList());
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

    private void loadCustomers()
    {
        DataRepository.getInstance().loadData();
        customerArrayList = new ArrayList();
        HashMap<String, Customer> customerHashMap = DataRepository.getInstance().getCustomerMap();
        Collection<Customer> demoValues = customerHashMap.values();
        tempCustomerArrayList = new ArrayList<>(demoValues);
        customerArrayList.addAll(tempCustomerArrayList);
    }

//    public String loadJSONFromAsset() {
//        String json = null;
//        try {
//            InputStream is = getAssets().open("Customer.json");
//            int size = is.available();
//            byte[] buffer = new byte[size];
//            is.read(buffer);
//            is.close();
//            json = new String(buffer, StandardCharsets.UTF_8);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//            return null;
//        }
//        return json;
//    }
//
//    private void readJson()
//    {
//        String js = loadJSONFromAsset();
//        if(js!=null)
//        {
//            try {
//                JSONArray jsonArray = new JSONArray(js);
//                tempCustomerListArrayList = new ArrayList<>();
//                for(int i=0; i<jsonArray.length();i++)
//                {
//                    JSONObject jsonObject = jsonArray.getJSONObject(i);
//                    if(jsonObject.has("id"))
//                    {
//                        String customerId = jsonObject.getString("customerId");
//                        String firstName = jsonObject.getString("firstName");
//                        String lastName = jsonObject.getString("lastName");
//                        String gender = jsonObject.getString("gender");
//                        String email = jsonObject.getString("email");
//                        String userName = jsonObject.getString("username");
//                        String password = jsonObject.getString("password");
//                        String location = jsonObject.getString("location");
//                        String dateOfBirth = jsonObject.getString("dateOfBirth");
//                        tempCustomerListArrayList.add(new Customer(customerId, firstName, lastName, gender, email, userName, password, location, dateOfBirth, R.drawable.icon_newuser));
//                    }
//                }
//                //c.setCustomerArrayList(customerArrayList);
//                DataRepository.getInstance().setCustomerDataList(tempCustomerListArrayList);
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//    }

}
