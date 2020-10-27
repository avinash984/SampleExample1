package com.learnandroid.sampleexample1.apis;

import com.learnandroid.sampleexample1.model.userdata.UsersList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("users")
    Call<List<UsersList>> getUsersData();
}

