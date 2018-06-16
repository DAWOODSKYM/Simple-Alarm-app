package com.example.dave.alarmapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.Toast;

public class Alarm extends BroadcastReceiver {
    //this impliments an abstract method (onReceive as seen below)
    @Override
    public void onReceive(Context context, Intent intent) {
        //go to the manifest file and add a receiver tag and give it the name of this class (this receives the new broadcast file we created)
        Toast.makeText(context, "Alarm.....", Toast.LENGTH_LONG).show();//after receiving the intent x it runs the toast and vibration service
        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);//to call the vibration service
        v.vibrate(1000);//you have to add the vibrate permission in the manifest

    }
}
