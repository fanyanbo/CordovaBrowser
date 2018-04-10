package skyworth.cordova_skyworth_hybrid_demo;

import android.support.v7.app.AppCompatActivity;
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

public class WebViewActivity extends CordovaExtActivity
        implements CordovaExtActivity.CordovaWebViewListener, CordovaExtActivity.CordovaWebViewDataListener, CordovaExtActivity.CordovaErrorPageListener {

    public String url = null;
    public int mode = 0;
    public boolean isCache = false;
    private static final String mTag = "WebViewSDK";

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {

        if(event.getAction() == KeyEvent.ACTION_DOWN){
            Log.i("WebViewSDK","keyCode = " + event.getKeyCode());
            if(event.getKeyCode() == 8){
                loadUrl("http://beta.webapp.skysrt.com/lxw/ceshi/nativeinfo2/index.html");
            }else if(event.getKeyCode() == 9){
                Map<String, String> map = new HashMap<String, String>();
                map.put("action", "download");
                map.put("params", "dfadsfgfsdgsaf");
                CoocaaOSApi.broadCastCommonChanged(this,map);
            }
        }
        return super.dispatchKeyEvent(event);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        setCordovaWebViewListener(this);
        setCordovaWebViewDataListener(this);
        setCordovaErrorPageListener(this);

        LOG.setLogLevel(LOG.VERBOSE);

        setWebViewDisplayPolicy(1);
      //  setCacheMode(1);

        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_webview);
    }

    @Override
    public void onSuperCmdInit() {
        url = getIntent().getStringExtra("url");
        mode = getIntent().getIntExtra("mode", 0);
        isCache = getIntent().getBooleanExtra("cache",false);
        if(isCache) setCacheMode(1);
        Log.i(mTag, "WebViewActivity url:" + url + ",mode:" + mode + ",isCache:" + isCache);

    //    url = "http://beta.webapp.skysrt.com/appstore/webxtest/test3/test.html";
    //    url = "http://beta.webapp.skysrt.com/lxw/ceshi/nativeinfo2/index.html";
   //     url = "http://beta.webapp.skysrt.com/lxw/ceshi/nfc2/index.html";
  //      url = "http://beta.webapp.skysrt.com/appstore/ad/index2.html"; //audi广告

    //    url = "http://beta.webapp.skysrt.com/games/test/test.html"; //监听demo

    //    url = "http://beta.webapp.skysrt.com/fyb/screensaver/index.html";

        if(mode == 0) {
            loadUrl(url);
        }else if(mode == 1) {
            loadUrl(url,true,true,null);
        }else{

        }
    }

    @Override
    public void onPageStarted(String url) {

    }

    @Override
    public void onPageFinished(String url) {

    }

    @Override
    public void onPageError(int errorCode, String description, String failingUrl) {

    }

    @Override
    public void notifyMessage(String data) {

    }

    @Override
    public void notifyLogInfo(String eventId, Map<String, String> map) {

    }

    @Override
    public void notifyPageResume(String pageName, Map<String, String> map) {

    }

    @Override
    public void notifyPagePause(String pageName) {

    }

    @Override
    public void handleUI(String value) {

    }
}
