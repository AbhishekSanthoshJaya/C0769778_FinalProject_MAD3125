package com.aby.c0769778_finalproject_mad3125.abhishek.ui

import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.aby.c0769778_finalproject_mad3125.R
import java.io.IOException
import java.nio.charset.StandardCharsets

class AboutUsWebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us_web_view)

        val myWebView: WebView = findViewById(R.id.wvAboutUs)

        val mAction = supportActionBar
        mAction!!.title = "ABOUT US"

        val assetManager = this.assets

        try {
            val inputStream = assetManager.open("aboutus.html")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            val content = String(buffer, StandardCharsets.UTF_8)
            Log.d("DATA", content)
            myWebView?.loadData(content, "text/html", "utf-8")
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}