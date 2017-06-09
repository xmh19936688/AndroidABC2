package com.xmh.androidabc2;

import android.app.IntentService;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
    }

    private void normalService() {
        startService(new Intent(this, NormalService.class));
        stopService(new Intent(this, NormalService.class));
    }

    private void bindService() {
        //use array for final
        final BindService.Binder_[] binder = new BindService.Binder_[1];
        ServiceConnection conn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                binder[0] = (BindService.Binder_) service;
                binder[0].process();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };

        bindService(new Intent(this, BindService.class), conn, BIND_AUTO_CREATE);
        unbindService(conn);
    }

    private void intentService() {
        startService(new Intent(this, IntentService_.class));
    }
}

class NormalService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        //when create
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
        //every time call start
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}

class BindService extends Service {

    private Binder_ binder = new Binder_();

    class Binder_ extends Binder {

        public void process() {
            //to in service
        }

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
}

class IntentService_ extends IntentService {

    public IntentService_(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        // do in other thread
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //auto destroy after handle-intent
    }
}