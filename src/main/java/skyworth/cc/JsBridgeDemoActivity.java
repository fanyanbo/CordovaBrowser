package skyworth.cc;

import android.os.Bundle;
import android.util.Log;

import org.lzyzsd.jsbridge.JsBridgeActivity;

public class JsBridgeDemoActivity extends JsBridgeActivity{

    public String url = null;
    private static final String TAG = "jsbridge";

    @Override
    public void onCreate(Bundle savedInstanceState) {

        Log.i(TAG,"onCreate");
        super.onCreate(savedInstanceState);

//        loadUrl("http://beta.webapp.skysrt.com/lxw/ceshi/nfc2/index.html");
        loadUrl("http://beta.webapp.skysrt.com/lxw/ceshi/test2/index2.html");
    }

}
