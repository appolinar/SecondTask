package com.appolinary.msappsecondtaskparsing.network;

import com.appolinary.msappsecondtaskparsing.data.LinkList;
import com.appolinary.msappsecondtaskparsing.data.VideoList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostAPI {
    @GET("/applicaster-employees/israel_team/Elad/assignment/link_json.json")
    Call<LinkList> getLinkData();



    @GET("/applicaster-employees/israel_team/Elad/assignment/video_json.json")
    Call<VideoList> getVideoData();
}
