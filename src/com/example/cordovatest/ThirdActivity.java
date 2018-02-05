package com.example.cordovatest;

import org.apache.cordova.CordovaBaseActivity;
import org.apache.cordova.CordovaExtActivity.CordovaWebViewListener;
import org.apache.cordova.CordovaExtWebView;

import com.skyworth.util.SkyScreenParams;
import com.tianci.system.data.SleepTimerData;

import android.graphics.Color;
import android.opengl.Visibility;
import android.os.Bundle;
import android.text.style.SuperscriptSpan;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class ThirdActivity extends CordovaBaseActivity implements CordovaWebViewListener{
	
	private FrameLayout mBg = null;
	private CordovaExtWebView mWebView = null;
	private Button mBtn = null;
	private static final String mErrorTimeout = "net::ERR_CONNECTION_TIMED_OUT";//error code:-8 webkit/android-weberro
	private int mErrorCode = 0;
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		mBg = new FrameLayout(this);
		mBg.setBackgroundColor(Color.RED);
		FrameLayout.LayoutParams mBgLp = new FrameLayout.LayoutParams(
			LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);     
		
		mWebView = new CordovaExtWebView(this);
		mWebView.setListener(this);
		mWebView.setBackgroundColor(Color.BLACK);
		//mWebView.setVisibility(View.INVISIBLE);
		FrameLayout.LayoutParams mWebViewLp = new FrameLayout.LayoutParams(SkyScreenParams.getInstence(this).getResolutionValue(960), SkyScreenParams.getInstence(this).getResolutionValue(540));
		mWebViewLp.gravity = Gravity.CENTER_HORIZONTAL;
		mBg.addView(mWebView,mWebViewLp);   
		
		mBtn = new Button(this);
		mBtn.setText("This is Android Button");
		mBtn.setBackgroundColor(Color.BLUE);
		mBg.addView(mBtn,new FrameLayout.LayoutParams(200, 100));
		
		mBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Log.i("fyb","Android Button is clicked");
			}
		});
		
		setContentView(mBg,mBgLp);
	}
	
	@Override
    public void onSuperCmdInit() {
    	Log.i("fyb","ThirdActivity------>onSuperCmdInit()");
    	
    }

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		mWebView.onCordovaWebViewPause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		mWebView.onCordovaWebViewResume();
		
		mWebView.loadUrl("http://beta.webapp.skysrt.com/fyb/webapp/index.html"); //会导致调用其他activity，再返回重复loadUrl
	//	mWebView.loadUrl("http://beta.webapp.skysrt.com/webappdemo/storage.html");
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		mWebView.onCordovaWebViewStart();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		
		mWebView.onCordovaWebViewStop();
	}
	
	@Override
	protected void onDestroy() {
		
		super.onDestroy();
		
		mWebView.onCordovaWebViewDestroy();
	}

	@Override
	public void onPageStarted(String url) {
		// TODO Auto-generated method stub
		Log.i("fyb","ThirdActivity onPageStarted url == "+ url);
		mErrorCode = 0;
	}

	@Override
	public void onPageFinished(String url) {
		// TODO Auto-generated method stub
		Log.i("fyb","ThirdActivity onPageLoadingFinished url == "+ url);
		if(mErrorCode != -8)
			mWebView.setVisibility(View.VISIBLE);
	}

	@Override
	public void onPageError(int errorCode, String description, String failingUrl) {
		// TODO Auto-generated method stub
		Log.i("fyb", "ThirdActivity errorCode == "
				+ errorCode + ", error description = "
				+ description + " failingUrl = " + failingUrl);
		mErrorCode = errorCode;
	}
}
