package com.appolinary.msappsecondtask.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VideoList {//server response
    @SerializedName("entry")
    private List<VideoModel> videos;

    public List<VideoModel> getVideos() {
        return videos;
    }


}

