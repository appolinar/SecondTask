package com.appolinary.msappsecondtaskparsing.business;

import android.util.Log;

import com.appolinary.msappsecondtaskparsing.data.BaseModel;
import com.appolinary.msappsecondtaskparsing.data.LinkList;
import com.appolinary.msappsecondtaskparsing.data.LinkModel;
import com.appolinary.msappsecondtaskparsing.data.VideoList;
import com.appolinary.msappsecondtaskparsing.data.VideoModel;
import com.appolinary.msappsecondtaskparsing.network.NetworkService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostInteractor implements IPostInteractor {
    private static final String TAG = "MSAPP";

    private List<BaseModel> totalList = new ArrayList<>();

    @Override
    public List<BaseModel> getTotalList() {
        return totalList;
    }

    @Override
    public void loadVideoData(final OnVideoListDownloadFinishedListener videoListDownloadFinishedListener) {
        NetworkService.getInstance()
                .getJSONApi()
                .getVideoData()
                .enqueue(new Callback<VideoList>() {
                    @Override
                    public void onResponse(Call<VideoList> call, Response<VideoList> response) {
                        if (response.body() != null) {
                            Log.d(TAG, "loadVideoData onResponse: response.body() = " + response.body());
                            List<VideoModel> resultList = new ArrayList<>(response.body().getVideos());
                            totalList.addAll(resultList);
                            videoListDownloadFinishedListener.onVideoListFinished(resultList);
                        }
                    }

                    @Override
                    public void onFailure(Call<VideoList> call, Throwable t) {
                        Log.d(TAG, "loadVideoData onFailure:");
                        t.printStackTrace();
                    }
                });

    }

    @Override
    public void loadLinkData(final OnLinkListDownloadFinishedListener linkListDownloadFinishedListener) {
        NetworkService.getInstance()
                .getJSONApi()
                .getLinkData()
                .enqueue(new Callback<LinkList>() {
                    @Override
                    public void onResponse(Call<LinkList> call, Response<LinkList> response) {
                        if (response.body() != null) {
                            Log.d(TAG, "loadLinkData onResponse: response.body() = " + response.body());
                            List<LinkModel> resultList = new ArrayList<>(response.body().getLinks());
                            totalList.addAll(resultList);
                            linkListDownloadFinishedListener.onLinkListFinished(resultList);
                        }
                    }

                    @Override
                    public void onFailure(Call<LinkList> call, Throwable t) {
                        Log.d(TAG, "loadLinkData onFailure:");
                        t.printStackTrace();
                    }
                });
    }
}
