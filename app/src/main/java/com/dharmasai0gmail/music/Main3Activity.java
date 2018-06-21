package com.dharmasai0gmail.music;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    Button bt1, bt2, bt3;
    MediaPlayer mp;
    SeekBar sb;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        handler = new Handler();
        mp = MediaPlayer.create(Main3Activity.this, R.raw.bajagovindam);
        sb = (SeekBar) findViewById(R.id.seekBar2);
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
        {
            @Override
            public void onPrepared(MediaPlayer mediaplayer)
            {
                sb.setMax(mp.getDuration());
            }
        });
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                if(mp!=null && fromUser)
                {
                    mp.seekTo(progress);

                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
        bt1 = (Button) findViewById(R.id.button11);
        bt1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(mp.isPlaying())
                {
                    Toast.makeText(getApplicationContext(),"already playing",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    mp.start();
                }
            }
        });
        bt2 = (Button) findViewById(R.id.button2);
        bt2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (mp.isPlaying())
                {
                    mp.pause();
                }
            }
        });
        bt3 = (Button) findViewById(R.id.button5);
        bt3.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                if (mp.isPlaying())
                {
                  mp.pause();
                  mp.seekTo(0);
                  sb.setProgress(0);
                }
            }
        });

    }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        mp.release();
        mp = null;
    }

}
