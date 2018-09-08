package skyworth.cc;

import android.util.Log;

import com.skyworth.framework.skysdk.ipc.SkyApplication;

/**
 * Created by fanyanbo on 2018/2/12.
 */

public class MainApplication extends SkyApplication{

    private static final String mTag = "WebViewSDK";

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        Log.i(mTag,"MainApplication onCreate");
    }
}
