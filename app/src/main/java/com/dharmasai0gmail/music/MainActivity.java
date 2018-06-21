package com.dharmasai0gmail.music;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void songs(android.view.View view)
    {
        android.content.Intent i = new android.content.Intent(this, Main2Activity.class);
        startActivity(i);
    }
    public void videos(android.view.View view)
    {
        android.content.Intent i = new android.content.Intent(this, Main6Activity.class);
        startActivity(i);
    }


}
