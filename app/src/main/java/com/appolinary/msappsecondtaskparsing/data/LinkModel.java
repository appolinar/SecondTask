package com.appolinary.msappsecondtaskparsing.data;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LinkModel extends BaseModel{
    @SerializedName("published")
    @Expose
    public String published;

    @SerializedName("link")
    @Expose
    public Link link;


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


}