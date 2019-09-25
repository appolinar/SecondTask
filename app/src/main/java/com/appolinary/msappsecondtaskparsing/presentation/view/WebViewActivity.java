package com.appolinary.msappsecondtaskparsing.presentation.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.appolinary.msappsecondtaskparsing.R;

public class WebViewActivity extends AppCompatActivity {
    private static final String WEBVIEW_URL = "url for webview";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);

        //TODO тут будет webview которая открывает url из интента
        String urlWebview = getIntent().getStringExtra(WEBVIEW_URL);
    }
}
