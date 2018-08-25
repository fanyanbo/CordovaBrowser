package skyworth.cordova_skyworth_hybrid_demo;

import android.os.Bundle;

import org.apache.cordova.CordovaExtActivity;

/**
 * Created by fanyanbo on 2018/8/23.
 * Email: fanyanbo@skyworth.com
 */
public class CordovaDemoActivity extends CordovaExtActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadUrl("http://beta.webapp.skysrt.com/lxw/ceshi/nfc2/index.html");
//        loadUrl("http://beta.webapp.skysrt.com/lxw/ceshi/nfc2/index.html");
    }
}
