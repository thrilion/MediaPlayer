package com.example.a5alumno.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MainActivity)";

    private MediaPlayer mPlayer;
    private Button playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.playButton = (Button) findViewById(R.id.btnPlayTrack);
        final Button stopButton = (Button) findViewById(R.id.btnStopTrack);
        final Button soundButton = (Button) findViewById(R.id.btnPlaySound);

        playButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
        soundButton.setOnClickListener(this);

        this.mPlayer = MediaPlayer.create(this, R.raw.darkwater);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnPlayTrack:
                if(this.mPlayer != null) {
                    if (!this.mPlayer.isPlaying()) {
                        this.mPlayer.start();
                        this.playButton.setText(R.string.btn_pause_text);
                    } else {
                        this.mPlayer.pause();
                        this.playButton.setText(R.string.btn_play_text);
                    }
                }
                break;
            case R.id.btnStopTrack:
                this.mPlayer.stop();
                try {
                    this.mPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btnPlaySound:
                break;
        }
    }
}
