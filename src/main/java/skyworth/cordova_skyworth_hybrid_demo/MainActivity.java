package skyworth.cordova_skyworth_hybrid_demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.skyworth.framework.skysdk.ipc.SkyActivity;
import com.tianci.system.api.TCSystemService;
import com.tianci.system.data.TCInfoSetData;
import com.tianci.system.data.TCSetData;
import com.tianci.system.define.TCEnvKey;

public class MainActivity extends Activity {

    private static final String mTag = "WebViewSDK";
    private TCSystemService mSystemApi;
    private Button btn;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private EditText editText;
    private CheckBox cb;
    private boolean mIsChecked = false;
    private boolean mIsHidden = false;
    private int core = 0;
    private Context mContext;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_1) {
            core = (core == 0) ? 1 : 0;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_main);
        setContentView(R.layout.layout);
        Log.i(mTag,"MainActivity onCreate");

        mContext = this;

        editText = (EditText)findViewById(R.id.content_url);
        cb = (CheckBox)findViewById(R.id.checkBox);
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.i(mTag,"onCheckedChanged isChecked = " + isChecked);
                mIsChecked = isChecked;
            }
        });

        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String urlcontent = editText.getText().toString();
                Log.i(mTag,"onClick!!! url = " + urlcontent);
                if( urlcontent != null && ( urlcontent.startsWith("http://") || urlcontent.startsWith("https://")))
                {
                    Intent mIntent = new Intent("com.intent.action.jsbridge");
                    mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mIntent.putExtra("url", urlcontent);
                    mIntent.putExtra("mode", 0);
                    mIntent.putExtra("core", core);
                    mIntent.putExtra("cache", mIsChecked);
                    startActivity(mIntent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "url is not illigel", Toast.LENGTH_LONG).show();
                }
            }
        });

        btn1 = (Button)findViewById(R.id.button1);
        btn1.setText("启动活动页");
        if (mIsHidden) btn1.setVisibility(View.INVISIBLE);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String urlcontent = "http://beta.webapp.skysrt.com/appstore/webxtest/test7/test.html";
                Log.i(mTag,"onClick!!! url = " + urlcontent);
                if( urlcontent != null && ( urlcontent.startsWith("http://") || urlcontent.startsWith("https://")))
                {
                    Intent mIntent = new Intent("com.intent.action.cordova");
                    mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mIntent.putExtra("url", urlcontent);
                    mIntent.putExtra("mode", 0);
                    mIntent.putExtra("core", core);
                    mIntent.putExtra("cache", mIsChecked);
                    startActivity(mIntent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "url is not illigel", Toast.LENGTH_LONG).show();
                }
            }
        });

        btn2 = (Button)findViewById(R.id.button2);
        btn2.setText("启动新本机信息");
        if (mIsHidden) btn2.setVisibility(View.INVISIBLE);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String urlcontent = "http://beta.webapp.skysrt.com/lxw/ceshi/nativeinfo2/index.html";
                Log.i(mTag,"onClick!!! url = " + urlcontent);
                if( urlcontent != null && ( urlcontent.startsWith("http://") || urlcontent.startsWith("https://")))
                {
                    Intent mIntent = new Intent("com.coocaa.webview.test");
                    mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mIntent.putExtra("url", urlcontent);
                    mIntent.putExtra("mode", 1);
                    mIntent.putExtra("core", core);
                    mIntent.putExtra("cache", mIsChecked);
                    startActivity(mIntent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "url is not illigel", Toast.LENGTH_LONG).show();
                }
            }
        });

        btn3 = (Button)findViewById(R.id.button3);
        btn3.setText("启动江苏广电盒子引导页");
        if (mIsHidden) btn3.setVisibility(View.INVISIBLE);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String urlcontent = "http://beta.webapp.skysrt.com/lxw/guide2/index.html";
                Log.i(mTag,"onClick!!! url = " + urlcontent);
                if( urlcontent != null && ( urlcontent.startsWith("http://") || urlcontent.startsWith("https://")))
                {
                    Intent mIntent = new Intent("com.coocaa.webview.test2");
                    mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mIntent.putExtra("url", urlcontent);
                    mIntent.putExtra("mode", 1);
                    mIntent.putExtra("core", core);
                    mIntent.putExtra("cache", mIsChecked);
                    startActivity(mIntent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "url is not illigel", Toast.LENGTH_LONG).show();
                }
            }
        });

        btn4 = (Button)findViewById(R.id.button4);
        btn4.setText("启动长图宣传页");
        if (mIsHidden) btn4.setVisibility(View.INVISIBLE);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String urlcontent = "http://beta.webapp.skysrt.com/lxw/ceshi/nfc2/index.html";
                Log.i(mTag,"onClick!!! url = " + urlcontent);
                if( urlcontent != null && ( urlcontent.startsWith("http://") || urlcontent.startsWith("https://")))
                {
//                    Intent mIntent = new Intent("com.coocaa.webview.test");
//                    mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    mIntent.putExtra("url", urlcontent);
//                    mIntent.putExtra("mode", 1);
//                    mIntent.putExtra("cache", mIsChecked);
//                    startActivity(mIntent);

//                    MainDialog.getInstance(mContext).show();

//                    Intent serviceIntent = new Intent(mContext, MainService.class);
//                    serviceIntent.putExtra("url","http://beta.webapp.skysrt.com/games/voice/index.html");
//                    startService(serviceIntent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "url is not illigel", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

//    @Override
//    public void onCmdConnectorInit() {
//        mSystemApi = new TCSystemService(this);
//        TCSetData modelSetData = mSystemApi
//                .getSetData(TCEnvKey.SKY_SYSTEM_ENV_MODEL);
//        String modelString = "";
//        if (modelSetData != null) {
//            TCInfoSetData modelInfoData = (TCInfoSetData) modelSetData;
//            modelString = modelInfoData.getCurrent();
//        }
//        Log.i(mTag,"MainActivity onCmdConnectorInit model = " + modelString);
//    }
//
//    @Override
//    public byte[] onHandler(String fromtarget, String cmd, byte[] body) {
//        return new byte[0];
//    }
//
//    @Override
//    public void onResult(String fromtarget, String cmd, byte[] body) {
//
//    }
//
//    @Override
//    public byte[] requestPause(String fromtarget, String cmd, byte[] body) {
//        return new byte[0];
//    }
//
//    @Override
//    public byte[] requestResume(String fromtarget, String cmd, byte[] body) {
//        return new byte[0];
//    }
//
//    @Override
//    public byte[] requestRelease(String fromtarget, String cmd, byte[] body) {
//        return new byte[0];
//    }
//
//    @Override
//    public byte[] requestStartToVisible(String fromtarget, String cmd, byte[] body) {
//        return new byte[0];
//    }
//
//    @Override
//    public byte[] requestStartToForground(String fromtarget, String cmd, byte[] body) {
//        return new byte[0];
//    }
}
