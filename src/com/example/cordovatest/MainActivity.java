package com.example.cordovatest;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnFocusChangeListener{

	private EditText editText;
	private Button btn1;
	private Button btn4;
	
	final Handler handler = new Handler() {
         public void handleMessage(Message msg) {
        	 Log.i("fyb","MainActivity handleMessage = " + msg.what);
             switch (msg.what) {
             case 1:
                 update();
                 break;
             }
             super.handleMessage(msg);
         }
         void update() {
             btn4.requestFocus();
        }
     };
     Timer timer = new Timer();
     TimerTask task = new TimerTask() {
         public void run() {
             Message message = new Message();
             message.what = 1;
             handler.sendMessage(message);
         }
     };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	//	timer.schedule(task, 1000 * 30); //启动timer
		
        editText = (EditText) findViewById(R.id.content_url);
        Button btn = (Button) findViewById(R.id.jump_url);
        btn.setVisibility(View.INVISIBLE);
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String urlcontent = editText.getText().toString();
				if( urlcontent!=null && ( urlcontent.startsWith("http://") || urlcontent.startsWith("https://")))
				{
//					PowerWebViewApi api = new PowerWebViewApi(MainActivity.this);
//					api.registListener("CordovaTest", new CordovaPageListener() {
//						
//						@Override
//						public void onPageError(int errorCode, String description, String failingUrl) {
//							// TODO Auto-generated method stub
//							Log.i("fyb","onPageError errorCode = " + errorCode);
//						}
//					});
//					api.startPowerWebView(urlcontent);
					
					Intent mIntent = new Intent("com.coocaa.powerwebview.test2");
					mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mIntent.putExtra("url", urlcontent);
					mIntent.putExtra("mode", 0);
					startActivity(mIntent);
				}
				else
				{
					Toast.makeText(MainActivity.this, "url is not illigel", Toast.LENGTH_LONG).show();
				}
			}
		});
        
        btn1 = (Button) findViewById(R.id.button1);
        btn1.setTag(1);
        btn1.setOnFocusChangeListener(this);
        btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String urlcontent = editText.getText().toString();
				if( urlcontent!=null && ( urlcontent.startsWith("http://") || urlcontent.startsWith("https://")))
				{		
					Intent mIntent = new Intent("com.coocaa.powerwebview.test");
					mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mIntent.putExtra("url", urlcontent);
					mIntent.putExtra("mode", 1);
					startActivity(mIntent);
				}
				else
				{
					Toast.makeText(MainActivity.this, "url is not illigel", Toast.LENGTH_LONG).show();
				}
			}
		});
        
        Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setTag(2);
        btn2.setOnFocusChangeListener(this);
        btn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String urlcontent = editText.getText().toString();
				if( urlcontent!=null && ( urlcontent.startsWith("http://") || urlcontent.startsWith("https://")))
				{					
					Intent mIntent = new Intent("com.coocaa.powerwebview.test");
					mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mIntent.putExtra("url", urlcontent);
					mIntent.putExtra("mode", 2);
					startActivity(mIntent);
				}
				else
				{
					Toast.makeText(MainActivity.this, "url is not illigel", Toast.LENGTH_LONG).show();
				}
			}
		});
        
        Button btn3 = (Button) findViewById(R.id.button3);
        btn3.setTag(3);
        btn3.setOnFocusChangeListener(this);
        btn3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String urlcontent = editText.getText().toString();
				if( urlcontent!=null && ( urlcontent.startsWith("http://") || urlcontent.startsWith("https://")))
				{					
					Intent mIntent = new Intent("com.coocaa.powerwebview.test");
					mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mIntent.putExtra("url", urlcontent);
					mIntent.putExtra("mode", 3);
					startActivity(mIntent);

				}
				else
				{
					Toast.makeText(MainActivity.this, "url is not illigel", Toast.LENGTH_LONG).show();
				}
			}
		});
        
        btn4 = (Button) findViewById(R.id.button4);
        btn4.setTag(4);
        btn4.setOnFocusChangeListener(this);
        btn4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String urlcontent = editText.getText().toString();
				if( urlcontent!=null && ( urlcontent.startsWith("http://") || urlcontent.startsWith("https://")))
				{					
					Intent mIntent = new Intent("com.coocaa.powerwebview.test3");
					mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mIntent.putExtra("url", urlcontent);
					mIntent.putExtra("mode", 4);
					startActivity(mIntent);
					
//					Intent intent = new Intent();  
//					intent.setPackage("com.coocaa.remotectrlservice");
//					intent.setAction("com.coocaa.action.remotectrl");  
//					intent.putExtra("cmd", "connect");
//					startService(intent);

				}
				else
				{
					Toast.makeText(MainActivity.this, "url is not illigel", Toast.LENGTH_LONG).show();
				}
			}
		});
        
	}

	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		// TODO Auto-generated method stub
		Log.i("fyb","view id = " + v.getTag());
		if(hasFocus){
		//	mMyFocusFrame.changeFocusPos(v);
		}
	}
	
	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		// TODO Auto-generated method stub
	//	Log.i("fyb", "MainActivity dispatchKeyEvent = " + event.getKeyCode());
		return super.dispatchKeyEvent(event);
	}
}































