package com.example.artests.l16;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Web extends AppCompatActivity {
    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        mWebView=(WebView)findViewById(R.id.webView);

        //Includes JavaScript
        mWebView.getSettings().setJavaScriptEnabled(true);

        //select page start
        //mWebView.loadUrl("http://ya.ru");
        Uri url=getIntent().getData();
        mWebView.setWebViewClient(new MyWebViewClient());
        mWebView.loadUrl(url.toString());

    }

    @Override
    public void onBackPressed() {
        if(mWebView.canGoBack()){
            mWebView.goBack();
        }
        else {
            super.onBackPressed();
        }
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

    }

}
