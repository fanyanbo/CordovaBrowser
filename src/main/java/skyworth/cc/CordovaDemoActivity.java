package skyworth.cc;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import org.apache.cordova.CordovaExtActivity;

/**
 * Created by fanyanbo on 2018/8/23.
 * Email: fanyanbo@skyworth.com
 */
public class CordovaDemoActivity extends CordovaExtActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        int monitor = intent.getIntExtra("monitor",0);
        if (monitor == 0) setPerformanceMonitor(true);
        setWebViewDisplayPolicy(1);
        if (url == null) url = "http://beta.webapp.skysrt.com/lxw/ceshi/nfc2/index.html";
        Log.d("WebViewSDK","onCreate monitor = " + monitor + ",url = " + url);
        loadUrl("http://beta.webapp.skysrt.com/games/yure/index.html");
//        loadUrl("http://beta.webapp.skysrt.com/lxw/ceshi/nfc2/index.html");
    }
}
