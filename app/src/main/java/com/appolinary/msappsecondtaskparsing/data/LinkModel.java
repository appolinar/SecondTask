package com.appolinary.msappsecondtaskparsing.data;

import android.content.Intent;
import android.view.View;

import com.appolinary.msappsecondtaskparsing.presentation.view.WebViewActivity;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LinkModel extends BaseModel implements View.OnClickListener {
    private static final String WEBVIEW_URL = "url for webview";

    @SerializedName("published")
    @Expose
    public String published;

    @SerializedName("link")
    @Expose
    public Link link;

    public Link getLink() {
        return link;
    }

    @Override
    public void onClick(View v) {
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
        public String href;

        public String getHref() {
            return href;
        }
    }


}