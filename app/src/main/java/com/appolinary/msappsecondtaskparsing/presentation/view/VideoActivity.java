package com.appolinary.msappsecondtaskparsing.presentation.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.appolinary.msappsecondtaskparsing.R;

public class VideoActivity extends AppCompatActivity {
    private static final String VIDEO_URL = "video url reference";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        //TODO прилетает интент с адресом, который надо открыть в mediaplayer
        String urlVideo = getIntent().getStringExtra(VIDEO_URL);
    }
}
