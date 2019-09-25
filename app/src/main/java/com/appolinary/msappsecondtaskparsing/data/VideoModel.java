package com.appolinary.msappsecondtaskparsing.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VideoModel {
    @SerializedName("type")
    @Expose
    public Type type;
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("summary")
    @Expose
    public String summary;
    @SerializedName("updated")
    @Expose
    public String updated;
    @SerializedName("link")
    @Expose
    public Link link;
    @SerializedName("author")
    @Expose
    public Author author;
    @SerializedName("content")
    @Expose
    public Content content;
    @SerializedName("ui_tag")
    @Expose
    public Object uiTag;
    @SerializedName("screen_type")
    @Expose
    public Object screenType;
    @SerializedName("media_group")
    @Expose
    public List<MediaGroup> mediaGroup = null;

    public class Author {
        @SerializedName("name")
        @Expose
        public String name;
    }

    public class Content {
        @SerializedName("src")
        @Expose
        public String src;
        @SerializedName("type")
        @Expose
        public String type;
    }

    public class Link {
        @SerializedName("rel")
        @Expose
        public String rel;
        @SerializedName("href")
        @Expose
        public String href;
    }

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
        @SerializedName("key")
        @Expose
        public String key;
        @SerializedName("type")
        @Expose
        public String type;
    }

    public class Type {
        @SerializedName("value")
        @Expose
        public String value;
    }
}
