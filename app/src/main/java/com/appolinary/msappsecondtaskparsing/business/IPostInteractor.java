package com.appolinary.msappsecondtaskparsing.business;

import com.appolinary.msappsecondtaskparsing.data.LinkModel;

import java.util.List;

public interface IPostInteractor {
    void loadVideoData();
    void loadLinkData(OnLinkListDownloadFinishedListener linkListDownloadFinishedListener);

    interface OnLinkListDownloadFinishedListener {
        void onFinished(List<LinkModel> links);
        void onFailure(Throwable t);
    }
}
