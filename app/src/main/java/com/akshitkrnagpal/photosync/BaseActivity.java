package com.akshitkrnagpal.photosync;

import android.app.Activity;
import android.os.Bundle;

import com.facebook.FacebookSdk;


public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
    }
}
