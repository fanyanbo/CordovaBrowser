package com.example.cordovatest;

import com.skyworth.framework.skysdk.ipc.SkyApplication;
import com.skyworth.theme.SkyThemeEngine;

import android.app.Application;
import android.util.Log;

public class MyApplication extends SkyApplication{
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		initTheme();
	}
	
	private void initTheme() {
		 Log.i("fyb","CordovaTest, initTheme()");
	     SkyThemeEngine.getInstance().init(this);
	}
}
