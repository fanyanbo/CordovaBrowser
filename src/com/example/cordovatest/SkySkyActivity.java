package com.example.cordovatest;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

import com.skyworth.framework.skysdk.ipc.SkyActivity;
import com.tianci.net.api.NetApiForWifi;

public class SkySkyActivity extends SkyActivity{
	
	NetApiForWifi netApi;
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		Log.i("fyb","SkySkyActivity onKeyDown keyCode = " + event.getKeyCode());
		if(KeyEvent.KEYCODE_1 == event.getKeyCode()){
			netApi.startScanWifiInfoList();
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public byte[] onHandler(String fromtarget, String cmd, byte[] body) {
		// TODO Auto-generated method stub
		Log.i("fyb","SkySkyActivity fromtarget = " + fromtarget + ",cmd = " + cmd);
		return null;
	}

	@Override
	public void onResult(String fromtarget, String cmd, byte[] body) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sky);
	}

	@Override
	@Deprecated
	public byte[] requestPause(String fromtarget, String cmd, byte[] body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Deprecated
	public byte[] requestResume(String fromtarget, String cmd, byte[] body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Deprecated
	public byte[] requestRelease(String fromtarget, String cmd, byte[] body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Deprecated
	public byte[] requestStartToVisible(String fromtarget, String cmd,
			byte[] body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Deprecated
	public byte[] requestStartToForground(String fromtarget, String cmd,
			byte[] body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCmdConnectorInit() {
		// TODO Auto-generated method stub
		Log.i("fyb","SkySkyActivity onCmdConnectorInit = ");
		netApi = new NetApiForWifi(this);
		
		
	}

}
