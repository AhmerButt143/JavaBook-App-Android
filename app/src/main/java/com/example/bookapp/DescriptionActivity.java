package com.example.bookapp;

import android.content.Context;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class DescriptionActivity extends AppCompatActivity {

    private static final String TAG="DescriptionActivity";
    private Context mContext;
    private Bundle extras;
    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        mContext=DescriptionActivity.this;
        webView=(WebView)findViewById(R.id.simpleWebView);
        extras=getIntent().getExtras();

        if(!extras.equals(null))
        {
            String data=extras.getString("titles");
            Log.d(TAG,"oncreate:the data is coming" + data);

            //Log.d(TAG,"oncreate:the data is coming"+data);
            String url="file:///android_asset/"+data+".html";//make url folder
            webView.loadUrl(url);
            WebSettings webSettings=webView.getSettings();
            webSettings.setBuiltInZoomControls(true);//finger wala zoom ha ye
            webSettings.setDisplayZoomControls(false);
            webSettings.setJavaScriptEnabled(true);

        }


    }
}
