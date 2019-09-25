package com.appolinary.msappsecondtaskparsing.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LinkList {
    @SerializedName("entry")
    private List<LinkModel> links;

    @Override
    public String toString() {
        return "LinkList{" +
                "links=" + links +
                '}';
    }
}
