package com.appolinary.msappsecondtaskparsing.presentation.view;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.appolinary.msappsecondtaskparsing.R;

public class VideoActivity extends AppCompatActivity {
    String urlVideo;
    private static final String VIDEO_URL = "video url reference";

    private VideoView videoView;
    private int mCurrentPosition = 0;
    private static final String PLAYBACK_TIME = "play_time";

    private TextView bufferingTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);


        urlVideo = getIntent().getStringExtra(VIDEO_URL);


        videoView = findViewById(R.id.videoview);
        bufferingTextView = findViewById(R.id.buffering_textview);

        if (savedInstanceState != null) {//TODO current position of player - replace to restoreInstanceState?
            mCurrentPosition = savedInstanceState.getInt(PLAYBACK_TIME);
        }


        MediaController controller = new MediaController(this);
        controller.setMediaPlayer(videoView);
        videoView.setMediaController(controller);
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

    private void initializePlayer() {
        showProgress();

        Uri videoUri = Uri.parse(urlVideo);//TODO need to catch exception?
        //TODO url is valid? check video url for different posts
        //TODO video pulled in height? no?

        videoView.setVideoURI(videoUri);

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                hideProgress();
                if (mCurrentPosition > 0) {
                    videoView.seekTo(mCurrentPosition);
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
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(PLAYBACK_TIME, videoView.getCurrentPosition());
    }


    public void showProgress() {
        bufferingTextView.setVisibility(VideoView.VISIBLE);

    }

    public void hideProgress() {
        bufferingTextView.setVisibility(VideoView.INVISIBLE);

    }

}
