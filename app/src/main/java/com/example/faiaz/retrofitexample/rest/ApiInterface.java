package com.example.faiaz.retrofitexample.rest;

import com.example.faiaz.retrofitexample.util.MyConstants;
import com.example.faiaz.retrofitexample.pojo.MultipleResource;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by FAIAZ on 11/24/2017.
 */

public interface ApiInterface {

//    @GET("/users/{user}/repos")
//    Call<List<GitHubRepo>> repoForUser(@Path("user") String user);

    @GET("" + MyConstants.API_END_DISTRICT)
    Call<MultipleResource> getFinalDistrictList(@QueryMap Map<String, String> params);




}
