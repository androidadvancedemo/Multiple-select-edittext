package com.nicksapp.edittextdemo;

import java.util.ArrayList;

import com.nicksapp.edittextlibrary.NicksAdapter;
import com.nicksapp.edittextlibrary.NicksItem;
import com.nicksapp.edittextlibrary.NicksMultiAutoCompleteTextview;

import com.startapp.android.publish.StartAppAd;
import com.startapp.android.publish.splash.SplashConfig;
import com.startapp.android.publish.splash.SplashConfig.Theme;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends Activity {
    private StartAppAd startAppAd = new StartAppAd(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 StartAppAd.init(MainActivity.this, "103205820", "203170552");
		setContentView(R.layout.activity_main);
		
		 StartAppAd.showSplash(this, savedInstanceState,
					new SplashConfig()
						.setTheme(Theme.SKY)
						.setLogo(R.drawable.ic_launcher)
						.setAppName("Multiple EditText")
			);
	       

	        StartAppAd.showSlider(this);
	    	startAppAd.loadAd(); // load the next ad
	       		startAppAd.showAd(); // show the ad
	       		startAppAd.loadAd(); // load the next ad
		
		NicksMultiAutoCompleteTextview ch= (NicksMultiAutoCompleteTextview) findViewById(R.id.NicksMultiAutoCompleteTextview1);
		
		String[] countries = getResources().getStringArray(R.array.country);
		TypedArray imgs = getResources().obtainTypedArray(R.array.flags);
		
		
		ArrayList<NicksItem> arrCountry = new ArrayList<NicksItem>();
		
		
		for(int i=0;i<countries.length;i++){
			arrCountry.add(new NicksItem(countries[i], imgs.getResourceId(i, -1) ));
			Log.i("Main Activity", arrCountry.get(i).getTitle() +  " = " + arrCountry.get(i).getImageid());
		}
		
		Log.i("MainActivity", "Array :" + arrCountry.size());
		
		NicksAdapter NicksAdapter = new NicksAdapter(this, arrCountry);
		ch.setAdapter(NicksAdapter);
		
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		startAppAd.onBackPressed();
		super.onBackPressed();
	}


	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		startAppAd.onResume();
		super.onResume();
	}
}
