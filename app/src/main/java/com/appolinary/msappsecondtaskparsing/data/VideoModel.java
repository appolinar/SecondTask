package com.appolinary.msappsecondtaskparsing.data;

import android.content.Intent;
import android.view.View;

import com.appolinary.msappsecondtaskparsing.presentation.view.VideoActivity;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class VideoModel extends BaseModel implements View.OnClickListener {
    private static final String VIDEO_URL = "video url reference";

    @SerializedName("content")
    @Expose
    public Content content;

    public class Content {
        @SerializedName("src")
        @Expose
        public String src;
        @SerializedName("type")
        @Expose
        public String type;

        public String getSrc() {
            return src;
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), VideoActivity.class);
        intent.putExtra(VIDEO_URL, this.getContent().getSrc());//passing url to video_activity
        v.getContext().startActivity(intent);
    }

    public View.OnClickListener getOnClickListener() {
        return this;
    }

    public Content getContent() {
        return content;
    }
}
