package com.aby.c0769778_finalproject_mad3125;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {
    private TextInputEditText edtEmailIdText;
    private TextInputEditText edtPasswordText;
    private TextInputLayout edtEmailId;
    private TextInputLayout edtPassword;
    private Button btnlogin;
    private Switch swchRememberMe;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public static final String PREFS_NAME = "MyPrefsFile";
    private static final String PREF_USERNAME = "username";
    private static final String PREF_PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        edtEmailIdText = findViewById(R.id.edtEmailIdText);
        edtPasswordText = findViewById(R.id.edtPasswordText);
        btnlogin = findViewById(R.id.btnLogin);
        swchRememberMe = findViewById(R.id.swchRememberMe);
        edtEmailId = findViewById(R.id.edtEmailId);
        edtPassword = findViewById(R.id.edtPassword);

        ArrayList<String> emailList = new ArrayList<>();
        ArrayList<String> passwordList = new ArrayList<>();

        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editor = sharedPreferences.edit();

        String email = sharedPreferences.getString(PREF_USERNAME, null);
        String password = sharedPreferences.getString(PREF_PASSWORD, null);
        edtEmailIdText.setText(email);
        edtPasswordText.setText(password);

        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray userArray = obj.getJSONArray("users");
            for (int i = 0; i < userArray.length(); i++) {
                JSONObject userInfo = userArray.getJSONObject(i);
                emailList.add(userInfo.getString("email"));
                passwordList.add(userInfo.getString("password"));
           }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edtEmailIdText.getText().toString().isEmpty()){
                    edtEmailId.setError("Enter your email address");
                }

                if(edtPasswordText.getText().toString().isEmpty()){
                    edtPassword.setError("Enter your password");
                    return;
                }

                for(int i=0, j =0; i<emailList.size(); i++,j++){
                    if(emailList.get(i).equals(edtEmailIdText.getText().toString()) && passwordList.get(i).equals(edtPasswordText.getText().toString()))
                    {
                        if(swchRememberMe.isChecked()){
                            editor.putString(PREF_USERNAME,edtEmailIdText.getText().toString());
                            editor.putString(PREF_PASSWORD,edtPasswordText.getText().toString());
                            editor.apply();
                        }
                        else
                        {
                            editor.putString(PREF_USERNAME,"");
                            editor.putString(PREF_PASSWORD,"");
                            editor.commit();
                        }
                        Intent mIntent = new Intent(LoginActivity.this, CustomerListActivity.class);
                        startActivity(mIntent);
                        return;
                    }
                }
                new MaterialAlertDialogBuilder(LoginActivity.this)
                        .setTitle("Invalid username or password")
                        .setMessage("Please check the information you entered")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        });
    }

    public void makeToast(String message){
        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("UserInformation.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
