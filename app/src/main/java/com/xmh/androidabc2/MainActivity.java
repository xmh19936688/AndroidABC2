package com.xmh.androidabc2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get info
        String info = savedInstanceState.getString("save");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //save info
        outState.putString("save","info");
        super.onSaveInstanceState(outState);
    }
}
