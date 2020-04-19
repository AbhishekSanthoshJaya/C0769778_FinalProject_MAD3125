package com.aby.c0769778_finalproject_mad3125.abhishek.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.DragStartHelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aby.c0769778_finalproject_mad3125.R;
import com.aby.c0769778_finalproject_mad3125.abhishek.model.Bill;
import com.aby.c0769778_finalproject_mad3125.abhishek.model.Hydro;
import com.aby.c0769778_finalproject_mad3125.abhishek.model.Internet;
import com.aby.c0769778_finalproject_mad3125.abhishek.model.Mobile;
import com.aby.c0769778_finalproject_mad3125.abhishek.util.DataRepository;
import com.aby.c0769778_finalproject_mad3125.abhishek.util.HelperMethods;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailedBillActivity extends AppCompatActivity {
    @BindView(R.id.txtFragBillId) TextView txtFragBillId;
    @BindView(R.id.txtFragBillDate) TextView txtFragBillDate;
    @BindView(R.id.txtFragDataUsed) TextView txtFragDataUsed;
    @BindView(R.id.txtFragManufac) TextView txtFragManufac;
    @BindView(R.id.txtFragPlanName) TextView txtFragPlanName;
    @BindView(R.id.txtFragMinsUsed) TextView txtFragMinsUsed;
    @BindView(R.id.txtFragBillAmount) TextView txtFragBillAmount;
    @BindView(R.id.imgBillType) ImageView imgBillType;
    @BindView(R.id.text4) TextView text4;
    @BindView(R.id.text5) TextView text5;
    @BindView(R.id.text6) TextView text6;
    @BindView(R.id.text7) TextView text7;
    Bill billObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_bill);
        ButterKnife.bind(this);

        Intent mIntent = getIntent();
        billObj = (Bill) mIntent.getSerializableExtra("BillObj");

        if(billObj.getBillId().contains("MB"))
        {
            Mobile m = (Mobile) billObj;
            txtFragBillId.setText(m.getBillId());
            txtFragBillDate.setText(m.getBillDate().toString());
            txtFragDataUsed.setText(HelperMethods.getInstance().gbFormatter(m.getMobGbUsed()));
            txtFragManufac.setText(m.getManufacturerName());
            txtFragPlanName.setText(m.getPlanName());
            txtFragMinsUsed.setText(HelperMethods.getInstance().minsFormatter(m.getMinute().toString()));
            txtFragBillAmount.setText(HelperMethods.getInstance().doubleFormatter(m.getBillTotal()));
            imgBillType.setImageResource(R.drawable.mobileicon);
            txtFragDataUsed.setVisibility(View.VISIBLE);
            txtFragMinsUsed.setVisibility(View.VISIBLE);
            text4.setText("Manufacturer");
            text5.setText("Plan Name");
        }
        if(billObj.getBillId().contains("HY"))
        {
            Hydro h = (Hydro) billObj;
            txtFragBillId.setText(h.getBillId());
            txtFragBillDate.setText(h.getBillDate().toString());
            txtFragPlanName.setText(HelperMethods.getInstance().gbFormatter(h.getUnitsUsed()));
            txtFragManufac.setText(h.getAgencyName());
            txtFragBillAmount.setText(HelperMethods.getInstance().doubleFormatter(h.getBillTotal()));
            imgBillType.setImageResource(R.drawable.watericon);
            text4.setText("Agency Name");
            text5.setText("Units Used");
            removeFields();
        }
        if(billObj.getBillId().contains("IN"))
        {
            Internet i = (Internet) billObj;
            txtFragBillId.setText(i.getBillId());
            txtFragBillDate.setText(i.getBillDate().toString());
            txtFragPlanName.setText(HelperMethods.getInstance().doubleFormatter(i.getGbUsed()));
            txtFragManufac.setText(i.getProviderName());
            txtFragBillAmount.setText(HelperMethods.getInstance().doubleFormatter(i.getBillTotal()));
            imgBillType.setImageResource(R.drawable.interneticon);
            text4.setText("Provider Name");
            text5.setText("Data Used");
            removeFields();
        }
    }

    public void removeFields()
    {
        txtFragDataUsed.setVisibility(View.INVISIBLE);
        txtFragMinsUsed.setVisibility(View.INVISIBLE);
        text6.setVisibility(View.INVISIBLE);
        text7.setVisibility(View.INVISIBLE);
    }
}
