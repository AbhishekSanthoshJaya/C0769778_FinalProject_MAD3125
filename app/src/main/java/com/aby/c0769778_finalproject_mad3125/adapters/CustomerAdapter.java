package com.aby.c0769778_finalproject_mad3125.adapters;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aby.c0769778_finalproject_mad3125.R;
import com.aby.c0769778_finalproject_mad3125.model.Customer;
import com.aby.c0769778_finalproject_mad3125.ui.AddCustomerActivity;
import com.aby.c0769778_finalproject_mad3125.ui.BillDetailsActivity;
import com.aby.c0769778_finalproject_mad3125.ui.CustomerListActivity;
import com.aby.c0769778_finalproject_mad3125.util.DataRepository;

import java.util.ArrayList;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder> {

    private ArrayList<Customer> customerArrayList;

    public CustomerAdapter(ArrayList<Customer> customerArrayList)
    {
        this.customerArrayList = customerArrayList;
    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.customer_cell
                        , parent
                        , false);
        CustomerViewHolder mCustomerViewHolder = new CustomerViewHolder(mView);
        return mCustomerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {
        Customer mCustomers = this.customerArrayList.get(position);
        holder.txtName.setText(mCustomers.getFirstName() + " "+ mCustomers.getLastName());
        holder.txtGenderLetter.setText(mCustomers.getGenderLetter());
        holder.imgCustomerIcon.setImageResource(mCustomers.getCustomerImg());
        holder.txtLocation.setText(mCustomers.getLocation());
        holder.txtCustomerId.setText(mCustomers.getCustomerId());
        holder.txtDoB.setText(mCustomers.getDateOfBirth());
        holder.txtUsername.setText(mCustomers.getUserName());
        holder.txtEmail.setText(mCustomers.getEmail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Customer customerObj = customerArrayList.get(position);
                DataRepository.getInstance().makeToast(customerObj.getBills().toString(), holder.itemView.getContext());

                Intent mIntent = new Intent(holder.itemView.getContext(), BillDetailsActivity.class);
                mIntent.putExtra("CustomerBills", customerObj);
                holder.itemView.getContext().startActivity(mIntent);


                //SERIALIZABLE CODE
//                Intent mIntent = new Intent(holder.itemView.getContext(), BillDetailsActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("billsKey", customerObj);
//                mIntent.putExtras(bundle);
//                holder.itemView.getContext().startActivity(mIntent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return this.customerArrayList.size();
    }

    public class CustomerViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;
        ImageView imgCustomerIcon;
        TextView txtLocation;
        TextView txtCustomerId;
        TextView txtDoB;
        TextView txtEmail;
        TextView txtUsername;
        TextView txtGenderLetter;

        public CustomerViewHolder(@NonNull View itemView)
        {
            super(itemView);
            imgCustomerIcon = itemView.findViewById(R.id.imgCustomerIcon);
            txtName = itemView.findViewById(R.id.txtName);
            txtLocation = itemView.findViewById(R.id.txtLocation);
            txtCustomerId = itemView.findViewById(R.id.txtCustomerID);
            txtDoB = itemView.findViewById(R.id.txtDoB);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            txtUsername = itemView.findViewById(R.id.txtUsername);
            txtGenderLetter = itemView.findViewById(R.id.txtGenderLetter);
        }
    }
}
