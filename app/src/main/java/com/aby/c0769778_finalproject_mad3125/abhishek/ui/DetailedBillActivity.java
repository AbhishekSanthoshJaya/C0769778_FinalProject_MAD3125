package com.aby.c0769778_finalproject_mad3125.abhishek.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.DragStartHelper;

import android.content.Intent;
import android.os.Bundle;
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
        }
        if(billObj.getBillId().contains("HY"))
        {
            Hydro h = DataRepository.getInstance().getHydroBill(billObj.getBillId());
            txtFragBillId.setText(h.getBillId());
        }
        if(billObj.getBillId().contains("IN"))
        {
            Internet i = DataRepository.getInstance().getInternetBill(billObj.getBillId());
            txtFragBillId.setText(i.getBillId());
        }
    }
}
