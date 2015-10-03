package com.testtask.xyrality.worldgames.rest;

import com.testtask.xyrality.worldgames.rest.GamesService;
import com.testtask.xyrality.worldgames.rest.model.WorldsResponse;
import com.testtask.xyrality.worldgames.ui.ResponceListener;
import retrofit.*;

/**
 * Created by Olena Bezuhla(jewelsalenka@gmail.com) on 10/3/15 2:41 PM .
 */
public class RestClient {
    private static final String BASE_URL = "http://backend1.lordsandknights.com/";
    private GamesService mGamesService;
    private ResponceListener mListener;

    public RestClient(ResponceListener listener) {
        mListener = listener;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mGamesService = retrofit.create(GamesService.class);
    }

    public void getGames(String email, String pass, String deviceType, String id){
        Call<WorldsResponse> responseCall = mGamesService.getGames(email, pass, deviceType, id);
        responseCall.enqueue(new Callback<WorldsResponse>() {
            @Override
            public void onResponse(Response<WorldsResponse> response) {
                WorldsResponse worldsResponse = response.body();
                mListener.onGetData(worldsResponse);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}
