package com.testtask.xyrality.worldgames.rest;

import com.testtask.xyrality.worldgames.rest.model.WorldsResponse;
import retrofit.Call;
import retrofit.http.*;

/**
 * Created by Olena Bezuhla(jewelsalenka@gmail.com) on 10/3/15 1:49 PM .
 */
public interface GamesService {
    @Headers({
            "Accept: application/json"
    })
    @POST("XYRALITY/WebObjects/BKLoginServer.woa/wa/worlds")
    Call<WorldsResponse> getGames(@Query("login") String email,
                  @Query("password") String password,
                  @Query("deviceType") String type,
                  @Query("deviceId") String id
    );
}
