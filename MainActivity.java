package com.streampro.elite;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebView = findViewById(R.id.webview);
        WebSettings webSettings = myWebView.getSettings();
        
        // REQUIRED: Enables the Search Dropdown and Category Pills
        webSettings.setJavaScriptEnabled(true); 
        
        // REQUIRED: Saves your "Watch History" and JJK progress to the phone
        webSettings.setDomStorageEnabled(true); 
        
        // Forces links to stay inside your app instead of opening Chrome
        myWebView.setWebViewClient(new WebViewClient());
        
        // Point this to your live Vercel URL
        myWebView.loadUrl("https://ayslovingmovies.vercel.app");
    }

    // Allows the physical "Back" button to navigate movie history 
    // instead of closing the app immediately
    @Override
    public void onBackPressed() {
        if (myWebView.canGoBack()) {
            myWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
