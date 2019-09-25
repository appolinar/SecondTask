package com.appolinary.msappsecondtaskparsing.data;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LinkModel {
    @SerializedName("type")
    @Expose
    public Type type;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("summary")
    @Expose
    public String summary;
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("published")
    @Expose
    public String published;
    @SerializedName("updated")
    @Expose
    public String updated;
    @SerializedName("content")
    @Expose
    public Content content;
    @SerializedName("link")
    @Expose
    public Link link;
    @SerializedName("media_group")
    @Expose
    public List<MediaGroup> mediaGroup = null;
    @SerializedName("author")
    @Expose
    public Author author;

    @Override
    public String toString() {
        return "LinkModel{" +
                "type=" + type +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", id='" + id + '\'' +
                ", published='" + published + '\'' +
                ", updated='" + updated + '\'' +
                ", content=" + content +
                ", link=" + link +
                ", mediaGroup=" + mediaGroup +
                ", author=" + author +
                '}';
    }

    public class Author {
        @SerializedName("name")
        @Expose
        public String name;
    }

    public class Content {
        @SerializedName("content")
        @Expose
        public String content;
        @SerializedName("type")
        @Expose
        public String type;
    }

    public class Link {
        @SerializedName("rel")
        @Expose
        public String rel;
        @SerializedName("type")
        @Expose
        public String type;
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