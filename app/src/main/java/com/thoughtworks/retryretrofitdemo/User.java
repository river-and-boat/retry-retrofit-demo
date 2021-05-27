package com.thoughtworks.retryretrofitdemo;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("auth_token")
    public String authToken;
    @SerializedName("data")
    public Object data;
    @SerializedName("error")
    public Boolean error;
    @SerializedName("message")
    public String message;
    @SerializedName("status_code")
    public Long statusCode;
}
