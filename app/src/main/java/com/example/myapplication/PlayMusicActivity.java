package com.example.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.IBinder;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Fragment.TitleFragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PlayMusicActivity extends AppCompatActivity {
    public static Song mSong;
    private TextView tvNameSong, tvNameSinger, tvTimeHT, tvTimeKT;
    private SeekBar sChangeVolume, sChaneTime;
    private ImageView imgBackGround, imgPlay_or_Pause, imgForward, imgRewind;
    private MusicService mMusicService;
    private Boolean isPlaying;
    private AudioManager audioManager;

    private Handler handler;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MusicService.MyBinder binder = (MusicService.MyBinder) iBinder;
            mMusicService = binder.getService();
            playSong();
            isPlaying = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isPlaying = true;
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_music_activity);
        mSong = (Song) getIntent().getExtras().get("song");

        handler = new Handler();
        innitUI();
        setData();

    }

    private void setData() {
        timeSong(mSong.getResourceSong());
        tvNameSinger.setText(mSong.getNameSinger());

        tvTimeKT.setText(timeSong(mSong.getResourceSong()));
        tvNameSong.setText(mSong.getNameSong());
        imgBackGround.setImageResource(mSong.getBackgroundSong());
        sChaneTime.setMax(MusicService.mediaPlayer.getDuration());
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                sChangeVolume.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
                sChangeVolume.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));

        sChangeVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onStopTrackingTouch(SeekBar arg0)
            {
            }

            @Override
            public void onStartTrackingTouch(SeekBar arg0)
            {
            }

            @Override
            public void onProgressChanged(SeekBar arg0, int progress, boolean arg2)
            {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
                        progress, 0);
            }
        });


    }

    private void innitUI() {
        tvNameSinger = findViewById(R.id.NameSinger);
        tvNameSong = findViewById(R.id.tvNameSong);
        tvTimeHT =findViewById(R.id.Time_HT);
        tvTimeKT = findViewById(R.id.Time_KT);
        sChaneTime = findViewById(R.id.change_time);
        sChangeVolume = findViewById(R.id.change_volume);
        imgBackGround = findViewById(R.id.bg_Song);
        imgForward = findViewById(R.id.forward);
        imgRewind = findViewById(R.id.rewind);
        imgPlay_or_Pause = findViewById(R.id.img_play);


    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, MusicService.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (isPlaying) {
            unbindService(connection);
            isPlaying = false;
        }
    }

    private String timeSong(int song){
        String time;
        MusicService.mediaPlayer = new MediaPlayer();
        MusicService.mediaPlayer = MediaPlayer.create(this, song);
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
        time = sdf.format(MusicService.mediaPlayer.getDuration());
        return time;
    }
    public void playSong(){
        mMusicService.StartMusic(mSong.getResourceSong());
        imgPlay_or_Pause.setImageResource(R.drawable.ic_pasue);

        sChaneTime.setMax(MusicService.mediaPlayer.getDuration());
        updateSeekbar();

    }

    private void updateSeekbar() {
        int current =  MusicService.mediaPlayer.getCurrentPosition();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");

                if ( String.valueOf(MusicService.mediaPlayer.getCurrentPosition() ) !=null){
                    tvTimeHT.setText(dateFormat.format( MusicService.mediaPlayer.getCurrentPosition()));
                }else {
                    MusicService.mediaPlayer.stop();
                }

                sChaneTime.setProgress( MusicService.mediaPlayer.getCurrentPosition());
                MusicService.mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        int vitri =    ListMusicAdapter.i ++;

                        if(vitri > TitleFragment.mSong.size()-1){
                            MusicService.mediaPlayer.stop();
                        }else {
                            MusicService.mediaPlayer.stop();
                            playSong();
                        }

                    }
                });
                handler.postDelayed(this, 500);
            }
        } ,100);
    }
}
