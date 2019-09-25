package com.appolinary.msappsecondtaskparsing.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VideoList {
    @SerializedName("entry")
    private List<VideoModel> videos;

    public List<VideoModel> getVideos() {
        return videos;
    }

    @Override
    public String toString() {
        return "VideoList{" +
                "videos = " + videos +
                '}';
    }
}

