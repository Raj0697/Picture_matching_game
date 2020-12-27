package com.example.brain_test;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

public class Myservice extends Service{
private MediaPlayer pl;
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId){
		super.onStartCommand(intent, flags, startId);
		pl = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
		pl.setLooping(true);
		pl.start();
		return START_STICKY;
	}
	
	@Override
	public void onDestroy(){
		super.onDestroy();
	}

}
