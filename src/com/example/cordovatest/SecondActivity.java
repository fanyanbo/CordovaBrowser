package com.example.cordovatest;

import java.util.Map;

import org.apache.cordova.CordovaExtActivity;
import org.apache.cordova.CordovaExtWebView;
import org.apache.cordova.LOG;
import org.apache.cordova.CordovaExtActivity.CordovaWebViewListener;
import org.apache.cordova.CordovaExtActivity.CordovaWebPageListener;
import org.apache.cordova.CordovaExtActivity.CordovaErrorPageListener;
import org.json.JSONException;
import org.json.JSONObject;

import com.skyworth.theme.SkyThemeEngine;
import com.skyworth.ui.blurbg.BlurBgLayout;
import com.tianci.webservice.data.SkyResponseData;
import com.tianci.webservice.data.SkyResponseErrorData;
import com.tianci.webservice.framework.IWebServiceBase;
import com.tianci.webservice.framework.SkyWebServerManager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

public class SecondActivity extends CordovaExtActivity implements CordovaWebViewListener, CordovaWebPageListener, CordovaErrorPageListener
{

	public BlurBgLayout mErrorBgLayout = null;
	public FrameLayout mBg = null;
	public CordovaExtWebView mWebView = null;
	public boolean isInterceptHomepageKey = false;
	public String url = null;
	public int mode = 0;
 
    public void onCreate(Bundle savedInstanceState)
    {
    	Log.i("fyb","SecondActivity onCreate");
    	SkyThemeEngine.getInstance().registerActivity(this);
        
        setCordovaWebViewListener(this);
        setCordovaWebPageListener(this);
        setCordovaErrorPageListener(this);
        
        LOG.setLogLevel(LOG.VERBOSE);
        setCacheMode(0);
        setUserAgentMode(1);
        setWebViewDisplayPolicy(1);
//      setAddTheme(false);
       
    	super.onCreate(savedInstanceState);
    	
//    	AndroidBug5497Workaround.assistActivity(this); //处理弹出输入法软键盘适配ui的类
    }

	@Override
    public void onSuperCmdInit() {
		
		url = getIntent().getStringExtra("url");
	    mode = getIntent().getIntExtra("mode", 1);
	    Log.i("fyb","SecondActivity url:"+url+",mode:" + mode);
//		NetApiForCommon netApi = new NetApiForCommon(mCmdProcessListener);
//    	Log.i("fyb","SecondActivity onSuperCmdInit  = " + netApi.getNetType());
//    	url = "http://beta.webapp.skysrt.com/lxw/tmall/index.html"; //测试天猫直播
//	    url = "http://beta.webapp.skysrt.com/lxw/play/index.html"; //测试直接跳转播放
//	    url = "http://beta.webapp.skysrt.com/webappdemo/index.html";
//    	url ="http://beta.webapp.skysrt.com/games/js2/index.html";
//	    url = "http://beta.webapp.skysrt.com/appstore/helps/index.html";
//	    url = "https://webapp.skysrt.com/vote/index.html";
//	    url = "http://beta.webapp.skysrt.com/lxw/shuangdan/index.html?source=tencent";
//	    url = "http://beta.webapp.skysrt.com/fyb/screensaver/index.html";
//	    url = "http://beta.webapp.skysrt.com/lxw/play/index.html";
//	    url = "http://beta.webapp.skysrt.com/fyb/longpic/index3.html";
//	    url = "https://webapp.skysrt.com/screen/index.html";	    
	    
	    if(mode == 0){
        	loadUrl(url,true,true,mErrorBgLayout);
        }else if(mode == 1){
        	loadUrl(url);
        }else if(mode == 2){
        	loadUrl(url,true,true,null);
        }else if(mode == 3){
        	mBg = new FrameLayout(this);
        	mBg.setBackgroundColor(Color.RED);
        	mBg.setLayoutParams(new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        	loadUrl(url,false,false,mBg);
        }else if(mode == 4){
        	mBg = new FrameLayout(this);
        	mBg.setBackgroundColor(Color.GRAY);
        	FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(1200, 800);
        	lp.gravity = Gravity.CENTER;
        	mBg.setLayoutParams(lp);
        	loadUrl(url,true,true,mBg);
        }
    }
	
	

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		
		Log.i("fyb","SecondActivity onKeyDown keyCode = " + event.getKeyCode());
		// TODO Auto-generated method stub
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		
//		int i= getWebViewFocusPosition();
		Log.i("fyb","SecondActivity dispatchKeyEvent keyCode = " + event.getKeyCode() + "action = " + event.getAction());
		if(KeyEvent.KEYCODE_1 == event.getKeyCode() && event.getAction() == 1){
//			Intent mIntent = new Intent("com.coocaa.powerwebview.test2");
//			mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//			mIntent.putExtra("url", url);
//			startActivity(mIntent);
//			this.finish();
		}
		// TODO Auto-generated method stub
		return super.dispatchKeyEvent(event);
	}

	@Override
	protected void onNewIntent(Intent intent) {
		// TODO Auto-generated method stub
		super.onNewIntent(intent);
		
		Log.i("fyb","SecondActivity ------->test onNewIntent()");
		String url = "http://beta.webapp.skysrt.com/fyb/webapp/index.html";
	//	appView.loadUrlIntoView(url, false);
	}

	@Override
	protected void onPause() {
		super.onPause();
		
//		mWebView.onSkyWebViewPause();
	//	Log.i("fyb","SecondActivity onPause");
	}

	@Override
	protected void onResume() {
		super.onResume();
		
		Log.i("fyb","SecondActivity onResume");
		
//		mWebView.onSkyWebViewResume();
	}

	@Override
	protected void onStop() {
		super.onStop();
		
		Log.i("fyb","SecondActivity onStop");
//		mWebView.onSkyWebViewStop();
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasFocus);
	}
	
	@Override
	protected void onRestart() {

		super.onRestart();
		
		Log.i("fyb","SecondActivity onRestart");
	}

	@Override
	protected void onStart() {
		super.onStart();
		
		Log.i("fyb","SecondActivity onStart");
//		mWebView.onSkyWebViewStart();
	}

	@Override
	public void onPageStarted(String url) {
		Log.i("fyb","SecondActivity onPageStarted url = " + url);
	}

	@Override
	public void onPageFinished(String url) {
		Log.i("fyb","SecondActivity onPageFinished url = " + url);
		new Handler().postDelayed(new Runnable(){   
		    public void run() {   
//				int i= getWebViewFocusPosition();
//				Log.i("fyb","SecondActivity onPageFinished getWebViewFocusPosition = " + i);
		    }   
		 }, 1000);   	
	}

	@Override
	public void onPageError(int errorCode, String description, String failingUrl) {
		// TODO Auto-generated method stub
		Log.i("fyb","SecondActivity onPageError url = " + failingUrl);
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
		Log.i("fyb","SecondActivity onDestroy");
		
//		mWebView.onSkyWebViewDestroy();
		
		SkyThemeEngine.getInstance().unRegisterActivity(this);
	}

	@Override
	public void notifyMessage(String data) {
		// TODO Auto-generated method stub
		Log.i("fyb","notifyJsMessage data = " + data);
//		if(data != null){
//			try {
//				JSONObject dataJson = new JSONObject(data);
//				if(dataJson.getBoolean("homepageIntercept"))
//					isInterceptHomepageKey = true;
//			} catch (JSONException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
	}

	@Override
	public void notifyLogInfo(String eventId, Map<String, String> map) {
		// TODO Auto-generated method stub
		Log.i("fyb","notifyLogInfo eventId = " + eventId);
		Log.i("fyb","notifyLogInfo map = " + map);
	}
	
	@Override
	public void handleUI(String value) {
		Log.i("fyb","handleUI value = " + value);
	//	this.finish();
	}
	
}
