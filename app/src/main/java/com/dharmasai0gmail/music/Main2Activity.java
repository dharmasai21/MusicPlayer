package com.dharmasai0gmail.music;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void bajagovindam(android.view.View view)
    {
        android.content.Intent i = new android.content.Intent(this, Main3Activity.class);
        startActivity(i);
    }
    public void vandemataram(android.view.View view)
    {
        android.content.Intent i = new android.content.Intent(this, Main5Activity.class);
        startActivity(i);
    }
}
