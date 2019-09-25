package com.appolinary.msappsecondtaskparsing.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VideoModel extends BaseModel{
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
    }
}
