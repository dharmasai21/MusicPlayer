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

public class Main5Activity extends AppCompatActivity {

    Button bt1, bt2, bt3;
    MediaPlayer mp1;
    SeekBar sb;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        handler = new Handler();
        mp1 = MediaPlayer.create(Main5Activity.this, R.raw.vandemataram);
        sb = (SeekBar) findViewById(R.id.seekBar4);
        mp1.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mp1.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
        {
            @Override
            public void onPrepared(MediaPlayer mediaplayer)
            {
                sb.setMax(mp1.getDuration());
            }
        });
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                if(mp1!=null && fromUser)
                {
                    mp1.seekTo(progress);

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
        bt1 = (Button) findViewById(R.id.button19);
        bt1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(mp1.isPlaying())
                {
                    Toast.makeText(getApplicationContext(),"already playing",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    mp1.start();
                }
            }
        });
        bt2 = (Button) findViewById(R.id.button28);
        bt2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (mp1.isPlaying())
                {
                    mp1.pause();
                }
            }
        });
        bt3 = (Button) findViewById(R.id.button29);
        bt3.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                if (mp1.isPlaying())
                {
                    mp1.pause();
                    mp1.seekTo(0);
                    sb.setProgress(0);
                }
            }
        });

    }
    /* public void playCycle()
      {
          sb.setProgress(mp.getCurrentPosition());

          if (mp.isPlaying()) {
              runnable = new runnable()
              {
                  @Override
                  public void run() {
                      playCycle();
                  }
              };
              handler.postDelayed(runnable, 100);
          }
      }*/
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        mp1.release();
        mp1 = null;
    }

}
