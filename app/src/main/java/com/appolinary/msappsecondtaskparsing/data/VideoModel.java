package com.appolinary.msappsecondtaskparsing.data;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.appolinary.msappsecondtaskparsing.presentation.view.VideoActivity;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import static androidx.core.content.ContextCompat.startActivity;

public class VideoModel extends BaseModel implements View.OnClickListener {
    private static final String URL = "url reference";

    @SerializedName("content")
    @Expose
    public Content content;

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(v.getContext(), VideoActivity.class);
        intent.putExtra(URL, this.getContent().getSrc());//passing url to video_activity
        startActivity(intent);

    }

    public View.OnClickListener getOnClickListener() {
        return this;
    }

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

    public Content getContent() {
        return content;
    }


}
