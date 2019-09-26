package com.appolinary.msappsecondtaskparsing.presentation.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.appolinary.msappsecondtaskparsing.R;

public class VideoActivity extends AppCompatActivity {
    private static final String TAG = "MSAPP";

    String urlVideo;
    private static final String VIDEO_URL = "video url reference";

    private VideoView videoView;
    private int currentPosition = 0;
    private static final String PLAYBACK_TIME = "play_time";

    private TextView bufferingTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);


        urlVideo = getIntent().getStringExtra(VIDEO_URL);
        Log.d(TAG, "onCreate: inside videoActivity obtained urlVideo = " + urlVideo);

        videoView = findViewById(R.id.videoview);
        bufferingTextView = findViewById(R.id.buffering_textview);

        MediaController controller = new MediaController(this);
        controller.setMediaPlayer(videoView);
        videoView.setMediaController(controller);
        
        if (savedInstanceState != null) {//restore previous position of player
            currentPosition = savedInstanceState.getInt(PLAYBACK_TIME);
        }
        playVideoFromPosition(currentPosition);
    }

    private void playVideoFromPosition(int currentPosition) {
        videoView.seekTo(currentPosition);
        videoView.start();
    }

    @Override
    protected void onStart() {
        super.onStart();
        initializePlayer();
    }

    @Override
    protected void onStop() {
        releasePlayer();
        super.onStop();
    }

    @Override
    protected void onPause() {
        videoView.pause();
        super.onPause();
    }

//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        play();
//
//    }
//
//    public void play() {
//        videoView.stopPlayback();
//        videoView.requestFocus();
//        videoView.start();
//        if (currentPosition != -1) {
//            videoView.seekTo(currentPosition);
//        }
//    }


    private void initializePlayer() {
        showProgress();

        Uri videoUri = Uri.parse(urlVideo);//if uri no valid - catch exception?

        videoView.setVideoURI(videoUri);

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                hideProgress();
                if (currentPosition > 0) {
                    videoView.seekTo(currentPosition);
                } else {
                    videoView.seekTo(1);
                }
                videoView.start();

            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(VideoActivity.this, "video finished", Toast.LENGTH_LONG).show();
                videoView.seekTo(1);
            }
        });
    }

    private void releasePlayer() {
        videoView.stopPlayback();
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {//save position if orientation changed(for example)
        super.onSaveInstanceState(outState);
        if (videoView.isPlaying())
            outState.putInt(PLAYBACK_TIME, videoView.getCurrentPosition());
    }


    public void showProgress() {
        bufferingTextView.setVisibility(VideoView.VISIBLE);

    }

    public void hideProgress() {
        bufferingTextView.setVisibility(VideoView.INVISIBLE);

    }

}
