package com.appolinary.msappsecondtaskparsing.business;

import com.appolinary.msappsecondtaskparsing.data.LinkModel;
import com.appolinary.msappsecondtaskparsing.data.VideoModel;

import java.util.List;

public interface IPostInteractor {
    void loadVideoData(OnVideoListDownloadFinishedListener videoListDownloadFinishedListener);
    void loadLinkData(OnLinkListDownloadFinishedListener linkListDownloadFinishedListener);

    interface OnLinkListDownloadFinishedListener {
        void onLinkListFinished(List<LinkModel> links);
        void onFailure(Throwable t);
    }
    interface OnVideoListDownloadFinishedListener {
        void onVideoListFinished(List<VideoModel> videos);
        void onFailure(Throwable t);
    }
}
