package com.akshitkrnagpal.photosync.fragments;


import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.akshitkrnagpal.photosync.R;
import com.akshitkrnagpal.photosync.models.AlbumsResponse;
import com.akshitkrnagpal.photosync.models.Datum;
import com.akshitkrnagpal.photosync.network.API;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.squareup.picasso.Picasso;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GalleryFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getActivity().getApplicationContext());

        ProfileTracker profileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {

                if(currentProfile!=null){

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(API.BASEURL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    API api = retrofit.create(API.class);

                    retrofit2.Call<AlbumsResponse> albumsResponseCall = api.getAlbums(AccessToken.getCurrentAccessToken().getToken());
                    albumsResponseCall.enqueue(callback);
                }
            }
        };
    }

    Callback callback = new Callback<AlbumsResponse>() {

        @Override
        public void onResponse(retrofit2.Call<AlbumsResponse> call, Response<AlbumsResponse> response) {
            int code = response.code();
            if (code == 200) {
                AlbumsResponse albumsResponse = response.body();

                // Response recieved..

            } else {
                Toast.makeText(getActivity(), "Did not work: " + code , Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onFailure(retrofit2.Call<AlbumsResponse> call, Throwable t) {
            Toast.makeText(getActivity(), "Did not work " +  t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gallery, container, false);
    }

}
