package skyworth.cordova_skyworth_hybrid_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.apache.cordova.CordovaExtActivity;
import org.apache.cordova.LOG;

import java.util.Map;

public class WebViewActivity extends CordovaExtActivity
        implements CordovaExtActivity.CordovaWebViewListener, CordovaExtActivity.CordovaWebPageListener, CordovaExtActivity.CordovaErrorPageListener {

    public String url = null;
    public int mode = 0;
    private static final String mTag = "WebViewSDK";

    @Override
    public void onCreate(Bundle savedInstanceState) {

        setCordovaWebViewListener(this);
        setCordovaWebPageListener(this);
        setCordovaErrorPageListener(this);

        LOG.setLogLevel(LOG.VERBOSE);

        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_webview);
    }

    @Override
    public void onSuperCmdInit() {
        url = getIntent().getStringExtra("url");
        mode = getIntent().getIntExtra("mode", 1);
        Log.i(mTag, "WebViewActivity url:" + url + ",mode:" + mode);

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
    public void handleUI(String value) {

    }
}
