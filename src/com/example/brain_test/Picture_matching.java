package com.example.brain_test;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class Picture_matching extends Activity implements OnItemClickListener {
	ImageView img = null;
	GridView gv;
	private int countpair = 0;
	final int[] images = {R.drawable.dog0,R.drawable.dog1,R.drawable.dog2,R.drawable.dog3,R.drawable.dog4,R.drawable.dog5,R.drawable.dog6,R.drawable.dog7};
	int pos[] = {0,1,2,3,4,5,6,7,0,1,2,3,4,5,6,7};
	int currentpos = -1;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_picture_matching);
		gv = (GridView)findViewById(R.id.gridView1);
		gv.setAdapter(new ImageAdapter(this));
		
		gv.setOnItemClickListener(this);
		MediaPlayer	pl = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
		pl.setLooping(true);
		pl.start();
	}


	@Override
	public void onItemClick(AdapterView<?> arg0, View v, int p, long id) {
		// TODO Auto-generated method stub
		img = (ImageView)v;
		if(currentpos < 0)
		{
			currentpos = p;
			((ImageView)v).setImageResource(images[pos[p]]);
		}
		else
		{
			if(currentpos == p)
			{
				((ImageView)v).setImageResource(R.drawable.hidden);
			}
			else if(pos[currentpos]!=pos[p])
			{
				img.setImageResource(R.drawable.hidden);
				Toast.makeText(this, "Not match", Toast.LENGTH_SHORT).show();
			}
			else
			{
				((ImageView)v).setImageResource(images[pos[p]]);
				countpair++;
				
				if(countpair == 0)
				{
					Toast.makeText(this, "you win", Toast.LENGTH_SHORT).show();
				}
			}
			currentpos = -1;
		}
	}
}
