package com.appolinary.msappsecondtaskparsing.presentation.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.appolinary.msappsecondtaskparsing.R;

public class VideoActivity extends AppCompatActivity {
    private static final String VIDEO_URL = "video url reference";
    //TODO TUT выровнять кнопку чтобы ровно посередеине под картинкой была

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        String urlVideo = getIntent().getStringExtra(VIDEO_URL);
    }
}
