package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.security.Provider;
import java.util.List;
import java.util.Map;

public class Myservice extends Service {
    private MediaPlayer mp;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mp = MediaPlayer.create(this, Settings.System.DEFAULT_NOTIFICATION_URI);
        mp.setLooping(true);
        mp.start();
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        return START_NOT_STICKY;

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.setLooping(false);
        mp.stop();

        Toast.makeText(this,"Service stopped",Toast.LENGTH_LONG).show();
    }
}
