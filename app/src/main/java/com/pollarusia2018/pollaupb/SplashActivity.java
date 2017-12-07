package com.pollarusia2018.pollaupb;

import android.*;
import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class SplashActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks{

    private Context context;
    private static final int RC_ALL_PERMISSIONS_REQUIRED = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        context = this;
        methodRequiresPermissions();
    }

    @AfterPermissionGranted(RC_ALL_PERMISSIONS_REQUIRED)
    private void methodRequiresPermissions() {
        String[] perms = {
                android.Manifest.permission.READ_CONTACTS,
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };

        if (EasyPermissions.hasPermissions(this, perms)) {

            TimerOut timeOut=new TimerOut();
            timeOut.execute();

        } else {
            // Do not have permissions, request them now
            EasyPermissions.requestPermissions(this, "Permisos!",
                    RC_ALL_PERMISSIONS_REQUIRED, perms);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {

    }

    class TimerOut extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            try
            {
                Thread.sleep(5000); // 5 miliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Intent mainIntent = new Intent(context,InvitarActivity.class);
            startActivity(mainIntent);
            finish();
        }
    }
}
