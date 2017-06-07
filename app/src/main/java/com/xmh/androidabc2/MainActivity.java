package com.xmh.androidabc2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //save info
        outState.putString("save","info");
        super.onSaveInstanceState(outState);
    }
}
