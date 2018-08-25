package skyworth.cordova_skyworth_hybrid_demo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import org.apache.cordova.CordovaExtActivity;

/**
 * Created by fanyanbo on 2018/8/24.
 * Email: fanyanbo@skyworth.com
 */
public class UriActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Uri uri = getIntent().getData();
        String url = uri.toString();
        Log.i("TEST","uri = " + url);
        if ("myapp://baidu".equals(url)) {
            Log.i("TEST","uri 111 = " + url);
            Intent mIntent = new Intent("com.intent.action.cordova");
            mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(mIntent);
        } else if ("myapp://coocaa".equals(url)) {

        }
        finish();
    }
}
