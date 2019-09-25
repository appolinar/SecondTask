package com.appolinary.msappsecondtaskparsing.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static final String BASE_URL = "http://assets-production.applicaster.com/";
    private static NetworkService networkServiceInstance;
    private Retrofit retrofit;

    public static NetworkService getInstance(){
        if(networkServiceInstance == null)
            networkServiceInstance = new NetworkService();
        return networkServiceInstance;
    }

    private NetworkService(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public PostAPI getJSONApi() {
        return retrofit.create(PostAPI.class);
    }
}
