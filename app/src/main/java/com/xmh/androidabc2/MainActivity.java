package com.xmh.androidabc2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get info
        String info = savedInstanceState.getString("save");

        //send standard broadcast
        sendBroadcast(new Intent().setAction("action"));
        //send ordered broadcast without permission
        sendOrderedBroadcast(new Intent().setAction("action"),null);
        //send ordered broadcast with permission
        sendOrderedBroadcast(new Intent().setAction("action"),"permission");
    }

    private void localBroad(){
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);

        //register
        localBroadcastManager.registerReceiver(null,null);
        //unregister
        localBroadcastManager.unregisterReceiver(null);

        //send normal broadcast
        localBroadcastManager.sendBroadcast(new Intent().setAction("action"));
        //send synchronized broadcast
        localBroadcastManager.sendBroadcastSync(new Intent().setAction("action"));
    }

    private void sharedPreferences(){
        Context app=getApplicationContext();
        app.getSharedPreferences("name",MODE_PRIVATE);
        //:/data/data/{package}/shared_prefs/

        Activity activity=this;
        activity.getPreferences(MODE_PRIVATE);
        //will call
        getSharedPreferences(getLocalClassName(), MODE_PRIVATE);

        PreferenceManager.getDefaultSharedPreferences(app);
        PreferenceManager.getDefaultSharedPreferences(activity);
        //will call
        app.getSharedPreferences(app.getPackageName() + "_preferences", MODE_PRIVATE);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //save info
        outState.putString("save","info");
        super.onSaveInstanceState(outState);
    }
}
