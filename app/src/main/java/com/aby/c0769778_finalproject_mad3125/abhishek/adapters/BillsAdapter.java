package com.aby.c0769778_finalproject_mad3125.abhishek.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aby.c0769778_finalproject_mad3125.R;
import com.aby.c0769778_finalproject_mad3125.abhishek.model.Bill;
import com.aby.c0769778_finalproject_mad3125.abhishek.ui.DetailedBillActivity;
import com.aby.c0769778_finalproject_mad3125.abhishek.ui_fragments.MobileBillsFragment;
import com.aby.c0769778_finalproject_mad3125.abhishek.util.HelperMethods;

import java.util.ArrayList;

public class BillsAdapter extends RecyclerView.Adapter<BillsAdapter.BillsViewHolder> {

    public static ArrayList<Bill> billArrayList;

    public BillsAdapter(ArrayList<Bill> billArrayList)
    {
        this.billArrayList = billArrayList;
    }

    @NonNull
    @Override
    public BillsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bill_cell
                        , parent
                        , false);
        BillsAdapter.BillsViewHolder mBillsViewHolder = new BillsAdapter.BillsViewHolder(mView);
        return mBillsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BillsViewHolder holder, int position) {
        Bill mBills = this.billArrayList.get(position);
        if(mBills.getBillId().contains("MB"))
        {
            holder.imgCellBillType.setImageResource(R.drawable.mobileicon);
        }
        if(mBills.getBillId().contains("HY")) {
            holder.imgCellBillType.setImageResource(R.drawable.watericon);
        }
        if(mBills.getBillId().contains("IN")) {
            holder.imgCellBillType.setImageResource(R.drawable.interneticon);
        }
        holder.txtCellBillId.setText(mBills.getBillId());
        holder.txtCellBillAmount.setText(HelperMethods.getInstance().doubleFormatter(mBills.getBillTotal()));
        holder.txtCellBillDate.setText(mBills.getBillDate().toString());
        holder.txtCellBillType.setText(mBills.getBillType().toString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bill billObj = billArrayList.get(position);
                if(billObj.getBillId().contains("MB")) {
                    Intent mIntent = new Intent(holder.itemView.getContext(), MobileBillsFragment.class);
                    mIntent.putExtra("Bills", billObj);
                    holder.itemView.getContext().startActivity(mIntent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.billArrayList.size();
    }
    public class BillsViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtCellBillId;
        TextView txtCellBillDate;
        TextView txtCellBillType;
        TextView txtCellBillAmount;
        ImageView imgCellBillType;

        public BillsViewHolder(@NonNull View itemView)
        {
            super(itemView);
            txtCellBillId = itemView.findViewById(R.id.txtCellBillId);
            txtCellBillDate = itemView.findViewById(R.id.txtCellBillDate);
            txtCellBillType = itemView.findViewById(R.id.txtCellBillType);
            txtCellBillAmount = itemView.findViewById(R.id.txtCellBillAmount);
            imgCellBillType = itemView.findViewById(R.id.imgCellBillType);
        }
    }
}
