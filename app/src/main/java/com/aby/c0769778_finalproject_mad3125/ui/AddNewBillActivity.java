package com.aby.c0769778_finalproject_mad3125.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.aby.c0769778_finalproject_mad3125.R;
import com.aby.c0769778_finalproject_mad3125.model.Bill;
import com.aby.c0769778_finalproject_mad3125.model.Mobile;
import com.aby.c0769778_finalproject_mad3125.util.DataRepository;
import com.aby.c0769778_finalproject_mad3125.util.HelperMethods;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddNewBillActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    @BindView(R.id.spnBillType) Spinner spnBillType;
    @BindView(R.id.edtBillId)
    TextInputLayout edtBillId;
    @BindView(R.id.edtBillIdText)
    TextInputEditText edtBillIdText;
    @BindView(R.id.edtNumber) TextInputLayout edtNumber;
    @BindView(R.id.edtNumberText) TextInputEditText edtNumberText;
    @BindView(R.id.edtBillDate) TextInputLayout edtBillDate;
    @BindView(R.id.edtBillDateText) TextInputEditText edtBillDateText;
    @BindView(R.id.edtDataUsed) TextInputLayout edtDataUsed;
    @BindView(R.id.edtDataUsedText) TextInputEditText edtDataUsedText;
    @BindView(R.id.edtMinsUsed) TextInputLayout edtMinsUsed;
    @BindView(R.id.edtMinsUsedText) TextInputEditText edtMinsUsedText;
    @BindView(R.id.edtManufacName) TextInputLayout edtManufacName;
    @BindView(R.id.edtManufacNameText) TextInputEditText edtManufacNameText;
    @BindView(R.id.edtPlanName) TextInputLayout edtPlanName;
    @BindView(R.id.edtPlanNameText) TextInputEditText edtPlanNameText;
    @BindView(R.id.edtUnitsUsed) TextInputLayout edtUnitsUsed;
    @BindView(R.id.edtUnitsUsedText) TextInputEditText edtUnitsUsedText;
    @BindView(R.id.edtAgencyName) TextInputLayout edtAgencyName;
    @BindView(R.id.edtAgencyNameText) TextInputEditText edtAgencyNameText;
    @BindView(R.id.btnBillAdd) Button  btnBillAdd;
    @BindView(R.id.btnBillClear) Button btnBillClear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_bill);
        ButterKnife.bind(this);

        ArrayList<String> billType = new ArrayList<>();
        billType.add("MOBILE");
        billType.add("HYDRO");
        billType.add("INTERNET");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, billType);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnBillType.setAdapter(dataAdapter);

        spnBillType.setOnItemSelectedListener(this);

        btnBillClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearfields();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(position == 0)
        {
            initFields();
            clearfields();
            edtUnitsUsed.setVisibility(View.INVISIBLE);
            edtAgencyName.setVisibility(View.INVISIBLE);
            btnBillAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Mobile mObj = new Mobile   (edtBillIdText.getText().toString(),
                            HelperMethods.getInstance().stringToDate(edtBillDateText.getText().toString()),
                            Bill.BillType.Mobile,
                            edtManufacNameText.getText().toString(),
                            edtPlanNameText.getText().toString(),
                            edtNumberText.getText().toString(),
                            Integer.parseInt(edtDataUsedText.getText().toString()),
                            Integer.parseInt(edtMinsUsedText.getText().toString()));
                DataRepository.getInstance().makeToast(mObj.toString(), AddNewBillActivity.this);
                }
            });

        }
        if(position == 1)
        {
            hidefields();
            clearfields();
            edtUnitsUsed.setVisibility(View.VISIBLE);
            edtAgencyName.setVisibility(View.VISIBLE);
        }

        if(position == 2)
        {
            hidefields();
            clearfields();
            edtUnitsUsed.setVisibility(View.VISIBLE);
            edtAgencyName.setVisibility(View.VISIBLE);
            edtAgencyName.setHint("ENTER PROVIDER NAME");
            edtUnitsUsed.setHint("ENTER DATA USED");
        }
        ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
        ((TextView) parent.getChildAt(0)).setTextSize(18);
        ((TextView) parent.getChildAt(0)).setTypeface(null,Typeface.BOLD);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void initFields()
    {
        edtMinsUsed.setVisibility(View.VISIBLE);
        edtNumber.setVisibility(View.VISIBLE);
        edtDataUsed.setVisibility(View.VISIBLE);
        edtMinsUsed.setVisibility(View.VISIBLE);
        edtPlanName.setVisibility(View.VISIBLE);
        edtManufacName.setVisibility(View.VISIBLE);
    }
    public void hidefields()
    {
        edtMinsUsed.setVisibility(View.INVISIBLE);
        edtNumber.setVisibility(View.INVISIBLE);
        edtDataUsed.setVisibility(View.INVISIBLE);
        edtMinsUsed.setVisibility(View.INVISIBLE);
        edtPlanName.setVisibility(View.INVISIBLE);
        edtManufacName.setVisibility(View.INVISIBLE);
    }

    public void clearfields()
    {
        edtNumberText.getText().clear();
        edtDataUsedText.getText().clear();
        edtMinsUsedText.getText().clear();
        edtPlanNameText.getText().clear();
        edtManufacNameText.getText().clear();
        edtBillDateText.getText().clear();
        edtBillIdText.getText().clear();
        edtAgencyNameText.getText().clear();
        edtDataUsedText.getText().clear();
    }

}
