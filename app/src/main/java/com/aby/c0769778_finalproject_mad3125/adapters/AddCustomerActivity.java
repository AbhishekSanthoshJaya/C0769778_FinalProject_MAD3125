package com.aby.c0769778_finalproject_mad3125.adapters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.aby.c0769778_finalproject_mad3125.R;
import com.aby.c0769778_finalproject_mad3125.model.Customer;
import com.aby.c0769778_finalproject_mad3125.ui.CustomerListActivity;
import com.aby.c0769778_finalproject_mad3125.util.DataRepository;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddCustomerActivity extends AppCompatActivity {
    @BindView(R.id.edtCustomerId) TextInputLayout edtCustomerId;
    @BindView(R.id.edtFirstName) TextInputLayout edtFirstName;
    @BindView(R.id.edtLastName) TextInputLayout edtLastName;
    @BindView(R.id.edtBirthDate) TextInputLayout edtBirthDate;
    @BindView(R.id.rdBtnMale) RadioButton rdBtnMale;
    @BindView(R.id.rdBtnFemale) RadioButton rdBtnFemale;
    @BindView(R.id.rdBtnOther) RadioButton rdBtnOther;
    @BindView(R.id.edtUsername) TextInputLayout edtUsername;
    @BindView(R.id.edtEmail) TextInputLayout edtEmail;
    @BindView(R.id.edtPassword) TextInputLayout edtPassword;
    @BindView(R.id.edtLocation) TextInputLayout edtLocation;

    @BindView(R.id.edtCustomerIdText) TextInputEditText edtCustomerIdText;
    @BindView(R.id.edtFirstNameText) TextInputEditText edtFirstNameText;
    @BindView(R.id.edtLastNameText) TextInputEditText edtLastNameText;
    @BindView(R.id.edtBirthDateText) TextInputEditText edtBirthDateText;
    @BindView(R.id.edtUsernameText) TextInputEditText edtUsernameText;
    @BindView(R.id.edtEmailText) TextInputEditText edtEmailText;
    @BindView(R.id.edtPasswordText) TextInputEditText edtPasswordText;
    @BindView(R.id.edtLocationText) TextInputEditText edtLocationText;

    @BindView(R.id.btnAdd)
    Button btnAdd;
    @BindView(R.id.btnClear)
    Button btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
        ButterKnife.bind(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fieldChecker();
            }
        });
    }

    public void fieldChecker()
    {
        boolean someFlag = false;
        if(edtCustomerIdText.getText().toString().isEmpty())
        {
            edtCustomerId.setError("Please enter your customer ID");
            someFlag = true;
            return;
        }
        if(edtFirstNameText.getText().toString().isEmpty()){
            edtFirstName.setError("Please enter your first name");
            someFlag = true;
            return;
        }
        if(edtLastNameText.getText().toString().isEmpty())
        {
            edtLastName.setError("Please enter your last name");
            someFlag = true;
            return;
        }
        if(edtBirthDateText.getText().toString().isEmpty())
        {
            edtBirthDate.setError("Please enter your date of birth");
            someFlag = true;
            return;
        }
        if(edtUsernameText.getText().toString().isEmpty())
        {
            edtUsername.setErrorEnabled(true);
            edtUsername.setError("Please enter your username");
            someFlag = true;
            return;
        }
        if(edtEmailText.getText().toString().isEmpty())
        {
            edtEmail.setError("Please enter your email");
            someFlag = true;
            return;
        }
        if(edtPasswordText.getText().toString().isEmpty())
        {
            edtPassword.setErrorEnabled(true);
            edtPassword.setError("Please enter your password");
            someFlag = true;
            return;
        }
        if(edtLocationText.getText().toString().isEmpty())
        {
            edtLocation.setError("Please enter your location");
            someFlag = true;
            return;
        }
        if(!someFlag) {
            Customer customer = new Customer(edtCustomerIdText.getText().toString(),
                    edtFirstNameText.getText().toString(),
                    edtLastNameText.getText().toString(),
                    getGender(),
                    edtEmailText.getText().toString(),
                    edtUsernameText.getText().toString(),
                    edtPasswordText.getText().toString(),
                    edtLocationText.getText().toString(),
                    edtBirthDateText.getText().toString(),
                    R.drawable.icon_newuser);
            DataRepository.getInstance().getCustomerMap().put(customer.getCustomerId(), customer);
            Intent mIntent = new Intent(AddCustomerActivity.this, CustomerListActivity.class);
            mIntent.putExtra("Customer", customer);
            startActivity(mIntent);
        }
    }

    public String getGender()
    {
        if (rdBtnMale.isChecked()){
            return "Male";
        }
        else if (rdBtnFemale.isChecked()) {
            return "Female";
        }
        else if(rdBtnOther.isChecked())
        {
            return "Other";
        }
        return null;
    }

    public void clearfields()
    {
        edtUsernameText.getText().clear();
        edtPasswordText.getText().clear();
        edtBirthDateText.getText().clear();
        edtCustomerIdText.getText().clear();
        edtEmailText.getText().clear();
        edtLastNameText.getText().clear();
        edtFirstNameText.getText().clear();
        edtLocationText.getText().clear();

        rdBtnFemale.setChecked(false);
        rdBtnMale.setChecked(false);
        rdBtnOther.setChecked(false);


    }
}
