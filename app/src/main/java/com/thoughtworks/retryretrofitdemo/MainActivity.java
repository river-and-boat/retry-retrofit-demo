package com.thoughtworks.retryretrofitdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("https://androidwave.com/api/")
                .addCallAdapterFactory(RetryCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserApiService userApiService = retrofit.create(UserApiService.class);
        userApiService.getUsers().enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(getApplicationContext(), "Success " + response.body().message,
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failure " + t.getMessage(), Toast.LENGTH_LONG)
                        .show();
            }
        });
    }
}