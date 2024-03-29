package com.appolinary.msappsecondtask.data;

import android.content.Intent;
import android.view.View;

import com.appolinary.msappsecondtask.presentation.view.WebViewActivity;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LinkModel extends BaseModel implements View.OnClickListener {
    private static final String WEBVIEW_URL = "url for webview";

    @SerializedName("published")
    @Expose
    public String published;

    @SerializedName("link")
    @Expose
    private Link link;

    private Link getLink() {
        return link;
    }

    @Override
    public void onClick(View v) {//need for clicks inside recyclerview
        Intent intent = new Intent(v.getContext(), WebViewActivity.class);
        intent.putExtra(WEBVIEW_URL, this.getLink().getHref());
        v.getContext().startActivity(intent);
    }

    public View.OnClickListener getOnClickListener() {
        return this;
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
        private String href;

        private String getHref() {
            return href;
        }//our target reference for link-resources
    }


}