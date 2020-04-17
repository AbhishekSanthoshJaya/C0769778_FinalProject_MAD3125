package com.aby.c0769778_finalproject_mad3125.abhishek.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import com.aby.c0769778_finalproject_mad3125.R;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class AboutUsWebViewActivity extends AppCompatActivity {

    private WebView wvAboutUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us_web_view);

        wvAboutUs = findViewById(R.id.wvAboutUs);

        AssetManager assetManager = this.getAssets();
        try {
            InputStream inputStream = assetManager.open("aboutus.html");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            String content = new String(buffer, StandardCharsets.UTF_8);
            Log.d("DATA", content);
            wvAboutUs.loadData(content,"text/html","utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
