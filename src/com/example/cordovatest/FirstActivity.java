package com.example.cordovatest;

import org.apache.cordova.CordovaExtActivity;

import com.tianci.net.api.NetApiForCommon;

import android.os.Bundle;
import android.util.Log;

public class FirstActivity extends CordovaExtActivity {

	public String url = null;
	
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    
	@Override
    public void onSuperCmdInit() {
		
	//	SkyUserApi userApi = new SkyUserApi(mCmdProcessListener);
//		NetApiForCommon netApi = new NetApiForCommon(mCmdProcessListener);
		
//    	Log.i("fyb","FirstActivity---------->onSuperCmdInit  = " + netApi.getNetType());
        url = getIntent().getStringExtra("url");
        Log.i("fyb","FirstActivity onCreate url = " + url);
    	loadUrl(url);
    }

}
