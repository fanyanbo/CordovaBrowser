//package skyworth.cordova_skyworth_hybrid_demo;
//
//import android.app.Activity;
//import android.graphics.Color;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.Gravity;
//import android.view.KeyEvent;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.FrameLayout;
//import android.widget.LinearLayout;
//
//import com.skyworth.util.SkyScreenParams;
//
//import org.apache.cordova.CordovaExtWebView;
//import org.apache.cordova.LOG;
//
///**
// * Created by fanyanbo on 2018/6/5.
// * Email: fanyanbo@skyworth.com
// */
//
//public class WebViewActivity2 extends Activity{
//
//    LinearLayout layout;
//    private FrameLayout mMainLayout = null;
//    private final static String mTag = "WebViewSDK";
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        CordovaWebViewSingleton.getInstance(getApplicationContext()).getView().onResume();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        CordovaWebViewSingleton.getInstance(getApplicationContext()).getView().onPause();
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//
//        Log.i("WebViewSDK","====================================>onCreate");
//
//        super.onCreate(savedInstanceState);
//
//        mMainLayout = new FrameLayout(this);
////        FrameLayout.LayoutParams webViewLp = new FrameLayout.LayoutParams(
////                SkyScreenParams.getInstence(this).getResolutionValue(1920), SkyScreenParams.getInstence(this).getResolutionValue(1080));
//
////        CordovaWebViewSingleton.getInstance(getApplicationContext()).getView().setCordovaExtWebViewListener(new CordovaExtWebView.CordovaExtWebViewListener() {
////            @Override
////            public void onPageStarted(String url) {
////                Log.i(mTag,"WebViewActivity2 onPageStarted url = " + url);
////            }
////
////            @Override
////            public void onPageExit() {
////                Log.i(mTag,"WebViewActivity2 onPageExit this = " + this);
////                WebViewActivity2.this.finish();
////            }
////
////            @Override
////            public void onPageFinished(String url) {
////                Log.i(mTag,"WebViewActivity2 onPageFinished url = " + url);
////            }
////
////            @Override
////            public void onPageError(int errorCode, String description, String failingUrl) {
////                Log.i(mTag,"WebViewActivity2 onPageError description = " + description);
////            }
////
////            @Override
////            public void onPageSslError(int errorCode, String failingUrl) {
////
////            }
////
////            @Override
////            public void onProgressChanged(int process) {
////
////            }
////        });
////        layout = new LinearLayout(this);
////        layout.addView(CordovaWebViewSingleton.getInstance(getApplicationContext()).getView());
////        final LinearLayout testLayout = new LinearLayout(this);
////        testLayout.setBackgroundColor(Color.WHITE);
////        testLayout.setAlpha(0.99f);
////        mMainLayout.addView(layout);
////        mMainLayout.addView(testLayout, new FrameLayout.LayoutParams(1920, 1080, Gravity.CENTER));
//
//        CordovaWebViewSingleton.getInstance(getApplicationContext()).getView().setAlpha(0.01f);
//        mMainLayout.addView(CordovaWebViewSingleton.getInstance(getApplicationContext()).getView());
//
//
//        FrameLayout.LayoutParams mainLp = new FrameLayout.LayoutParams(
//                SkyScreenParams.getInstence(this).getResolutionValue(1920), SkyScreenParams.getInstence(this).getResolutionValue(1080));
//        setContentView(mMainLayout,mainLp);
//
//
//        CordovaWebViewSingleton.getInstance(getApplicationContext()).getView().postDelayed(new Runnable() {
//            @Override
//            public void run() {
////                testLayout.setVisibility(View.GONE);
//                CordovaWebViewSingleton.getInstance(getApplicationContext()).getView().setAlpha(1f);
//            }
//        }, 1000);
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
////        CordovaWebViewSingleton.getInstance(this).onCordovaWebViewDestroy();
////        layout.removeAllViews();
//        mMainLayout.removeAllViews();
//    }
//
//    @Override
//    public boolean dispatchKeyEvent(KeyEvent event) {
//
//        if(event.getAction() == KeyEvent.ACTION_DOWN){
//            Log.i("WebViewSDK","dispatchKeyEvent keyCode = " + event.getKeyCode());
//        }
//        return super.dispatchKeyEvent(event);
//    }
//}
