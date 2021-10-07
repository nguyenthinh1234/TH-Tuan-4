package com.example.myapplication;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MusicService extends Service {
    private MyBinder mBinder = new MyBinder();
    private IBinder binder;
    public static MediaPlayer mediaPlayer;

    public class MyBinder extends Binder{
        MusicService getService(){
            return MusicService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("Servoce", "onCreate");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("Servoce", "onBind");
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("Servoce", "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.e("Servoce", "onDestroy");
        super.onDestroy();
        if (mediaPlayer !=null){
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }
    public void StartMusic(int Resource){
        if(mediaPlayer == null){
            mediaPlayer = MediaPlayer.create(getApplicationContext(), Resource);
        }
        mediaPlayer.start();
    }
    public void fastForward(int pos){
        mediaPlayer.seekTo(pos);
    }


    // dừng phát nhạc
    public void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }
}




