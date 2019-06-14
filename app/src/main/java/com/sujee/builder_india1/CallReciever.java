package com.sujee.builder_india1;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.MicrophoneDirection;
import android.media.MicrophoneInfo;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.Date;



public class CallReciever extends PhoneCaller {

    @Override
    protected void onIncomingCallReceived(Context ctx, String number, Date start)
    {
        Log.i("Dta","Phone recieved");
    }

    @Override
    protected void onIncomingCallAnswered(Context ctx, String number, Date start)
    {
        Log.i("Dta","Phone answered");
    }

    @Override
    protected void onIncomingCallEnded(Context ctx, String number, Date start, Date end)
    {
        Log.i("Dta","Phone ended");
    }

    @Override
    protected void onOutgoingCallStarted(Context ctx, String number, Date start)
    {
        Log.i("Dta","Phone out");


                AudioManager audioManager = (AudioManager) ctx.getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
                audioManager.setMode(AudioManager.MODE_IN_CALL);
                if (audioManager.isMicrophoneMute() == false) {
                    audioManager.setMicrophoneMute(true);
                    System.out.print("set");

                } else {
                    audioManager.setMicrophoneMute(false);

                }
                MainActivity.mediaPlayer.start();



    }


    @Override
    protected void onOutgoingCallEnded(Context ctx, String number, Date start, Date end)
    {
        Log.i("Dta","Phone outended");
        MainActivity.mediaPlayer.stop();

    }
    @Override
    protected void onMissedCall(Context ctx, String number, Date start)
    {
        Log.i("Dta","Phone yes");
    }

}

