package com.thoughtworks.retryretrofitdemo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserApiService {
    @Retry
    @GET("user")
    Call<User> getUsers();
}
