package com.appolinary.msappsecondtaskparsing.business;

import android.util.Log;

import com.appolinary.msappsecondtaskparsing.data.LinkList;
import com.appolinary.msappsecondtaskparsing.data.LinkModel;
import com.appolinary.msappsecondtaskparsing.network.NetworkService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostInteractor implements IPostInteractor {
    private static final String TAG = "MSAPP";
//    List<VideoModel> videoList;
    List<LinkModel> linkList;

    @Override
    public void loadVideoData() {


    }

    @Override
    public void loadLinkData(final OnLinkListDownloadFinishedListener linkListDownloadFinishedListener) {
        NetworkService.getInstance()
                .getJSONApi()
                .getLinkData()
                .enqueue(new Callback<LinkList>() {
                    @Override
                    public void onResponse(Call<LinkList> call, Response<LinkList> response) {
                        if(response.body()!=null) {
                            Log.d(TAG, "onResponse: response.body() = " + response.body());
                            List<LinkModel> resultList = new ArrayList<>();
                            for (LinkModel linkModel : response.body().getLinks()) {
                                resultList.add(linkModel);
                            }
                            linkList = resultList;
                            linkListDownloadFinishedListener.onFinished(resultList);

                        }
                    }

                    @Override
                    public void onFailure(Call<LinkList> call, Throwable t) {
                        Log.d(TAG, "onFailure:");
                        t.printStackTrace();

                    }
                });

    }
}
