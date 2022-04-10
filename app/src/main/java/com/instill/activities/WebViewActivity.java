package com.instill.activities;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.instill.R;
import com.instill.models.Suggestion;

public class WebViewActivity extends AppCompatActivity {

    Suggestion suggestion;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        suggestion = (Suggestion) getIntent().getSerializableExtra("suggestion");
        findViewById(R.id.imageViewBack).setOnClickListener(view -> onBackPressed());
        ((TextView) findViewById(R.id.txtHeading)).setText(suggestion.title);
        webView = findViewById(R.id.webView);

        webView.setWebViewClient(new MyWebViewClient());

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl(suggestion.link);

    }

    private static class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, String url) {
            webView.loadUrl(url); // load the url
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack())
            webView.goBack();
        else
            super.onBackPressed();
    }
}
