package com.appolinary.msappsecondtask.business;

import com.appolinary.msappsecondtask.data.BaseModel;
import com.appolinary.msappsecondtask.data.LinkModel;
import com.appolinary.msappsecondtask.data.VideoModel;

import java.util.List;

public interface IPostInteractor {
    void loadVideoData(OnVideoListDownloadFinishedListener videoListDownloadFinishedListener);
    void loadLinkData(OnLinkListDownloadFinishedListener linkListDownloadFinishedListener);

    List<BaseModel> getTotalList();

    interface OnLinkListDownloadFinishedListener {
        void onLinkListFinished(List<LinkModel> links);
        void onFailure(Throwable t);
    }
    interface OnVideoListDownloadFinishedListener {
        void onVideoListFinished(List<VideoModel> videos);
        void onFailure(Throwable t);
    }
}
