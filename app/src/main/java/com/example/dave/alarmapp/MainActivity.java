package com.example.dave.alarmapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    //objects
    Button alBtn;
    EditText alText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //map by id
        alBtn = (Button) findViewById(R.id.alBtn);

        alText = (EditText) findViewById(R.id.alText);

        //onclick listener for the button
        alBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //creat a new class for the alarm listener(see java class Alarm)

                int time = Integer.parseInt(alText.getText().toString());//This gets input time from the user

                Intent x = new Intent(MainActivity.this,Alarm.class);//this navigates from the main activity to the Alarm class

                PendingIntent pi =  PendingIntent.getBroadcast(getApplicationContext(),0,x,0);
                //this creats a pending intent and passes on the intent x through the alarm manager object to the alarm class
                AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);//this line calls the alarm class usingg the alarm manager

                am.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+time*1000,pi);//this line sets the alarm using the object am of the alarm manager

            }
        });
    }
}
