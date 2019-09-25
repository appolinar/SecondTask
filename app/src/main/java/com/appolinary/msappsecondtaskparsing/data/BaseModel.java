package com.appolinary.msappsecondtaskparsing.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseModel {
    @SerializedName("type")
    @Expose
    public Type type;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("summary")
    @Expose
    public String summary;
    @SerializedName("media_group")
    @Expose
    public List<MediaGroup> mediaGroup = null;

    public class MediaGroup {
        @SerializedName("type")
        @Expose
        public String type;
        @SerializedName("media_item")
        @Expose
        public List<MediaItem> mediaItem = null;
    }

    public class MediaItem {

        @SerializedName("src")
        @Expose
        public String src;
        @SerializedName("type")
        @Expose
        public String type;
        @SerializedName("scale")
        @Expose
        public String scale;
        @SerializedName("key")
        @Expose
        public String key;

    }
    public class Type {

        @SerializedName("value")
        @Expose
        public String value;

    }
}
