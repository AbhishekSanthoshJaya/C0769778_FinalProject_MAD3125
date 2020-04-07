package com.aby.c0769778_finalproject_mad3125.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aby.c0769778_finalproject_mad3125.R;
import com.aby.c0769778_finalproject_mad3125.model.Customer;

import org.w3c.dom.Text;

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
        holder.txtName.setText(mCustomers.getName());
        holder.imgCustomerIcon.setImageResource(mCustomers.getCustomerImg());
        holder.txtLocation.setText(mCustomers.getLocation());
        holder.txtCustomerId.setText(mCustomers.getCustomerId());
        holder.txtDoB.setText(mCustomers.getDateOfBirth());
        holder.txtUsername.setText(mCustomers.getUserName());
        holder.txtEmail.setText(mCustomers.getEmail());
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
        }
    }
}
