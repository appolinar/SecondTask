package com.appolinary.msappsecondtask.network;

import com.appolinary.msappsecondtask.data.LinkList;
import com.appolinary.msappsecondtask.data.VideoList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostAPI {
    @GET("/applicaster-employees/israel_team/Elad/assignment/link_json.json")
    Call<LinkList> getLinkData();



    @GET("/applicaster-employees/israel_team/Elad/assignment/video_json.json")
    Call<VideoList> getVideoData();
}
