package com.appolinary.msappsecondtaskparsing.data;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.appolinary.msappsecondtaskparsing.presentation.view.VideoActivity;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class VideoModel extends BaseModel implements View.OnClickListener {
    private static final String VIDEO_URL = "video url reference";
    private static final String TAG = "MSAPP";

    @SerializedName("content")
    @Expose
    private Content content;

    public class Content {
        @SerializedName("src")
        @Expose
        String src;
        @SerializedName("type")
        @Expose
        public String type;

        private String getSrc() {
            return src;
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), VideoActivity.class);
        Log.d(TAG, "onClick: inside videoModel url = " + this.getContent().getSrc());
        intent.putExtra(VIDEO_URL, this.getContent().getSrc());//passing url to video_activity
        v.getContext().startActivity(intent);
    }

    public View.OnClickListener getOnClickListener() {
        return this;
    }

    private Content getContent() {
        return content;
    }
}
