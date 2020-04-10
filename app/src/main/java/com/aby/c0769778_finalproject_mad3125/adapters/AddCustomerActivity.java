package com.aby.c0769778_finalproject_mad3125.adapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;

import com.aby.c0769778_finalproject_mad3125.R;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
        ButterKnife.bind(this);

        edtCustomerIdText.setText("something");

    }
}
