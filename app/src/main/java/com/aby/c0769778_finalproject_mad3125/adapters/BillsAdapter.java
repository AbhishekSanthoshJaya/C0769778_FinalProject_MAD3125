package com.aby.c0769778_finalproject_mad3125.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aby.c0769778_finalproject_mad3125.R;
import com.aby.c0769778_finalproject_mad3125.model.Bill;
import com.aby.c0769778_finalproject_mad3125.model.Customer;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class BillsAdapter extends RecyclerView.Adapter<BillsAdapter.BillsViewHolder> {

    private ArrayList<Bill> billArrayList;

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
        holder.txtCellBillAmount.setText(mBills.getBillTotal().toString());
        holder.txtCellBillDate.setText(mBills.getBillDate().toString());
        holder.txtCellBillType.setText(mBills.getBillType().toString());
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
