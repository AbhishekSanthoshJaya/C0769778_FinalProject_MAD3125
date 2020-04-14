package com.aby.c0769778_finalproject_mad3125.abhishek.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.aby.c0769778_finalproject_mad3125.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.jakewharton.threetenabp.AndroidThreeTen;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

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
        AndroidThreeTen.init(this);

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.hide();

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
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.welcome);

        String email = sharedPreferences.getString(PREF_USERNAME, null);
        String password = sharedPreferences.getString(PREF_PASSWORD, null);
        edtEmailIdText.setText(email);
        edtPasswordText.setText(password);

        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset("LoginInformation.json"));
            JSONArray userArray = obj.getJSONArray("users");
            for (int i = 0; i < userArray.length(); i++)
                {
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

                if(edtEmailIdText.getText().toString().isEmpty())
                {
                    edtEmailIdText.setError("Enter your email address");
                }

                if(edtPasswordText.getText().toString().isEmpty())
                {
                    edtPasswordText.setError("Enter your password");
                    return;
                }

                for(int i=0, j =0; i<emailList.size(); i++,j++)
                {
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
                            editor.apply();
                        }
                        mp.start();
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
                return;
            }
        });
    }

    public String loadJSONFromAsset(String filename) {
        String json = null;
        try {
            InputStream is = getAssets().open(filename);
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
