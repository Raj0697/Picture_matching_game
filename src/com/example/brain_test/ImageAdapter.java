package com.example.brain_test;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter  {
	
	private Context c;
	public ImageAdapter(Context c)
	{
		this.c=c;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 16;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View v, ViewGroup vg) {
		// TODO Auto-generated method stub
		ImageView img;
		
		if(v==null)
		{
			img = new ImageView(c);
			img.setLayoutParams(new GridView.LayoutParams(350,350));
			img.setScaleType(ImageView.ScaleType.FIT_XY);
			
		}
		else
			img = (ImageView)v;
			img.setImageResource(R.drawable.hidden);

		return img;
	}

}
