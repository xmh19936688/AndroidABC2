package com.xmh.androidabc2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PermissionActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE=0x01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

        permission();
    }

    private void permission(){
        //check permission before go
        if (ContextCompat.checkSelfPermission(PermissionActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            //request permission if didn't grant
            ActivityCompat.requestPermissions(PermissionActivity.this,new String[]{Manifest.permission.CALL_PHONE},PERMISSION_REQUEST_CODE);
        }else {
            go();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case PERMISSION_REQUEST_CODE:
                //handle user process
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    go();
                }else {
                    //user denied
                }
                break;
        }
    }

    private void go(){
        startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:10086")));
    }
}
