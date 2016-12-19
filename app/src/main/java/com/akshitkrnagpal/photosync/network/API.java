package com.akshitkrnagpal.photosync.network;

import com.akshitkrnagpal.photosync.models.AlbumsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {

    public static String BASEURL = "https://graph.facebook.com/v2.8/";

    @GET("/me/albums")
    Call<AlbumsResponse> getAlbums(@Query("access_token") String access_token);

}
