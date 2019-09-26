package com.appolinary.msappsecondtask.data;

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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<MediaGroup> getMediaGroups() {
        return mediaGroup;
    }

    public void setMediaGroup(List<MediaGroup> mediaGroup) {
        this.mediaGroup = mediaGroup;
    }

    public class MediaGroup {
        @SerializedName("type")
        @Expose
        public String type;
        @SerializedName("media_item")
        @Expose
        public List<MediaItem> mediaItem = null;

        public List<MediaItem> getMediaItems() {
            return mediaItem;
        }
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

        public String getSrc() {
            return src;
        }

        public String getKey() {
            return key;
        }
    }
    public class Type {

        @SerializedName("value")
        @Expose
        public String value;

    }
}
