package com.pollarusia2018.pollaupb.fcm;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by andresvasquez on 12/6/17.
 */

public class PollaInstanceIDService extends FirebaseInstanceIdService{

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        Log.d("TOKEN", FirebaseInstanceId.getInstance().getToken());
    }
}
