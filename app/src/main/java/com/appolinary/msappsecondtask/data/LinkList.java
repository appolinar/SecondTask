package com.appolinary.msappsecondtask.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LinkList {//intermediate class - server response before parsing
    @SerializedName("entry")
    private List<LinkModel> links;

    public List<LinkModel> getLinks() {
        return links;
    }


}
