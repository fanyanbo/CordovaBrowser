package skyworth.cordova_skyworth_hybrid_demo;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

import com.coocaa.cordova.plugin.CoocaaOSApi;

import org.apache.cordova.CordovaExtActivity;
import org.apache.cordova.LOG;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class WebViewActivity extends CordovaExtActivity
        implements CordovaExtActivity.CordovaWebViewListener,  CordovaExtActivity.CordovaWebPageListener/*, CordovaExtActivity.CordovaBusinessDataListener*/ {

    public String url = null;
    public int mode = 0;
    public boolean isCache = false;
    public int core = 0;
    private static final String mTag = "WebViewSDK";
    public Timer timer;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.i("WebViewSDK","onKeyDown keyCode = " + keyCode);
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {

     //   Log.i(mTag, "WebViewActivity dispatchKeyEvent keyCode = " + event.getKeyCode() + ",event = " + event.getAction() + ",tid = " + android.os.Process.myTid());
        if(event.getAction() == KeyEvent.ACTION_DOWN){
            Log.i("WebViewSDK","dispatchKeyEvent keyCode = " + event.getKeyCode());
//            if(event.getKeyCode() == 10){
//                loadUrl("http://172.20.139.227:3018/getcookie");
//            }
//            else if(event.getKeyCode() == 11){
//                loadUrl("http://172.20.139.227:3018/setcookie");
//            }
//            else if(event.getKeyCode() == 12){
//                loadUrl("http://beta.webapp.skysrt.com/games/cookie/cookie.html");
//            }
//            else if(event.getKeyCode() == 13){
//                loadUrl("http://beta.webapp.skysrt.com/games/cookie/cookie2.html");
//            }
//            else if(event.getKeyCode() == 8){
//                loadUrl("http://beta.webapp.skysrt.com/fyb/webapp/index.html");
            if(event.getKeyCode() == 9){
//                Map<String, String> map = new HashMap<String, String>();
//                map.put("action", "download");
//                map.put("params", "dfadsfgfsdgsaf");
//                CoocaaOSApi.broadCastVoiceChanged(this,map);
            }
        }
        return super.dispatchKeyEvent(event);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        Log.i("WebViewSDK","====================================>onCreate");

        setCordovaWebViewListener(this);
     //   setCordovaWebViewDataListener(this);
//        setCordovaBusinessDataListener(this);
        setCordovaWebPageListener(this);
        LOG.setLogLevel(LOG.VERBOSE);

        setWebViewDisplayPolicy(1);
        setCacheMode(0);
//        setCore(0);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSuperCmdInit() {
        url = getIntent().getStringExtra("url");
        mode = getIntent().getIntExtra("mode", 0);
        core = getIntent().getIntExtra("core", 0);
        setCore(core);
        isCache = getIntent().getBooleanExtra("cache",false);
        if(isCache) setCacheMode(1);
        Log.i(mTag, "WebViewActivity url:" + url + ",mode:" + mode + ",isCache:" + isCache + ",core:" + core);

   //     url = "https://webapp.skysrt.com/screen/index.html"; //监听demo
   //     url = "http://beta.webapp.skysrt.com/fyb/screensaver/index.html";
//        url = "http://beta.webapp.skysrt.com/fyb/study/index.html";
      //  url = "http://beta.webapp.skysrt.com/fyb/vue/dist/index.html";
//        url = "http://beta.webapp.skysrt.com/games/test/test.html";
//          url = "http://beta.webapp.skysrt.com/games/webappdemo/index.html";
//        url = "http://beta.webapp.skysrt.com/games/voice/index.html";
//        url = "http://beta.webapp.skysrt.com/games/webappdemo/index.html";
//        url = "http://beta.webapp.skysrt.com/fyb/canvas/2/index2.html";

        Log.i("WebViewSDK","================>ready to loadUrl url = " + url);
        if(mode == 0) {
            loadUrl(url);
        }else if(mode == 1) {
            loadUrl(url,true,true,null);
        }else{

        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        String url = getIntent().getStringExtra("url");
        int mode = getIntent().getIntExtra("mode",0);

        Log.i("WebViewSDK","onNewIntent url = " + url + ",mode = " + mode);
    }

    @Override
    public void onPageStarted(String url) {
        Log.i("WebViewSDK","==================>onPageStarted");
    }

    @Override
    public void onPageFinished(String url) {

    }

    @Override
    public void onPageError(int errorCode, String description, String failingUrl) {
        Log.i("fyb","onPageError errorCode = " + errorCode + ",description = " + description + ",url = " + failingUrl);
    }


//    @Override
//    public String getBusinessData(String data) {
//        Log.i("WebViewSDK","getBusinessData data = " + data);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return "aaa";
//    }

//    @Override
//    public String getBusinessData(String data, final BussinessCallback cb) {
////        try {
////            Thread.sleep(5000);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
////        cb.onResult("bbbbb");
//        timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                Log.i("WebViewSDK","getBusinessData timer----------->run");
//                cb.onResult("ccccc");
//            }
//        }, 5000);
//        Log.i("WebViewSDK","getBusinessData return----------->before");
//        return null;
//    }
//
//    @Override
//    public boolean setBusinessData(String data, final BussinessCallback cb) {
//        Log.i("WebViewSDK","setBusinessData data = " + data);
////        try {
////            Thread.sleep(5000);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                timer = new Timer();
//                timer.schedule(new TimerTask() {
//                    @Override
//                    public void run() {
//                        Log.i("WebViewSDK","setBusinessData timer----------->run");
//                        cb.onResult("error1");
//                        cb.onResult("error2");
//                        cb.onResult("error3");
//                        cb.onResult("success");
//                    }
//                }, 5000);
//            }
//        }).start();
//
//        return false;
//    }

    @Override
    public void notifyMessage(String data) {

    }

    @Override
    public void notifyLogInfo(String eventId, Map<String, String> map) {

    }

    @Override
    public void notifyPageResume(String eventId, Map<String, String> map) {

    }

    @Override
    public void notifyPagePause(String eventId) {

    }

//    @Override
//    public void submitPromotionData(String headers, String params) {
//        Log.i("TEST","WebViewActivity " + headers);
//        Log.i("TEST","WebViewActivity " + params);
//    }
}
