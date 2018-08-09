//package skyworth.cordova_skyworth_hybrid_demo;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//import android.content.pm.ActivityInfo;
//import android.util.Log;
//import android.widget.FrameLayout;
//
//import org.apache.cordova.CordovaExtWebView;
//import org.coocaa.webview.CoocaaOSConnecter;
//
//import java.util.Map;
//
///**
// * Created by fanyanbo on 2018/6/5.
// * Email: fanyanbo@skyworth.com
// */
//
//public class CordovaWebViewSingleton {
//    private final static String mTag = "WebViewSDK";
//
//    private static CordovaWebViewSingleton instance = null;
//    private CordovaExtWebView mWebView = null;
//    private int mStatus = 0;
//
//    private CordovaWebViewSingleton(Context context) {
//        init(context);
//    }
//
//    public static synchronized CordovaWebViewSingleton getInstance(Context context) {
//        if (instance == null) {
//            instance = new CordovaWebViewSingleton(context);
//        }
//        return instance;
//    }
//
//    private void init(final Context context) {
//
//        Log.i(mTag, "CordovaWebView initUI");
//
//        mWebView = new CordovaExtWebView(context);
//        mWebView.setBackgroundColor(0);
//        FrameLayout.LayoutParams webViewLp = new FrameLayout.LayoutParams(
//                FrameLayout.LayoutParams.MATCH_PARENT,
//                FrameLayout.LayoutParams.MATCH_PARENT);
//        mWebView.setLayoutParams(webViewLp);
//
//        mWebView.setCordovaExtWebViewListener(new CordovaExtWebView.CordovaExtWebViewListener() {
//
//            @Override
//            public void onPageStarted(String url) {
//                // TODO Auto-generated method stub
//                Log.i(mTag,"CordovaWebView onPageStarted url = " + url);
//
//                mStatus = -1;
//            }
//
//            @Override
//            public void onPageExit() {
//                Log.i(mTag,"CordovaWebView onPageExit Context = " + this);
//
//            }
//
//            @Override
//            public void onPageFinished(String url) {
//                // TODO Auto-generated method stub
//                Log.i(mTag,"CordovaWebView onPageFinished url = " + url);
//
//                mStatus = -1;
////                Intent dialogIntent = new Intent(context, WebViewActivity2.class);
////                dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
////                context.startActivity(dialogIntent);
//            }
//
//            @Override
//            public void onPageError(int errorCode, String description, String failingUrl) {
//                // TODO Auto-generated method stub
//                Log.i(mTag,"CordovaWebView onReceivedError url = " + failingUrl + ",description = " + description);
//
//                mStatus = -1;
//            }
//
//            @Override
//            public void onPageSslError(int errorCode, String failingUrl) {
//
//            }
//
//            @Override
//            public void onProgressChanged(int process) {
//                // TODO Auto-generated method stub
//                Log.i(mTag,"CordovaWebView onProgressChanged process = " + process);
//
//                mStatus = process;
//            }
//        });
//
//        mWebView.setCordovaExtWebViewDataListener(new CordovaExtWebView.CordovaExtWebViewDataListener(){
//
//            @Override
//            public void notifyMessage(String data) {
//                Log.i(mTag,"CordovaWebView notifyMessage data = " + data);
//            }
//
//            @Override
//            public void notifyLogInfo(String eventId, Map<String, String> map) {
//                Log.i(mTag,"CordovaWebView notifyLogInfo eventId = " + eventId);
//            }
//
//            @Override
//            public void notifyPageResume(String pageName, Map<String, String> map) {
//                Log.i(mTag,"CordovaWebView notifyPageResume pageName = " + pageName);
//            }
//
//            @Override
//            public void notifyPagePause(String pageName) {
//                Log.i(mTag,"CordovaWebView notifyPagePause pageName = " + pageName);
//            }
//        });
//
//    }
//
//    public void onCordovaWebViewPause()
//    {
//        mWebView.onPause();
//    }
//
//    public void onCordovaWebViewResume()
//    {
//        mWebView.onResume();
//    }
//
//    public void onCordovaWebViewStart()
//    {
//        mWebView.onStart();
//    }
//
//    public void onCordovaWebViewStop()
//    {
//        mWebView.onStop();
//    }
//
//    public void onCordovaWebViewDestroy()
//    {
//        mWebView.onDestroy();
//
//        if(mWebView != null) mWebView = null;
//        if(instance != null) instance = null;
//    }
//
//    public void loadUrl(final String url){
//        mWebView.loadUrl(url);
//    }
//
//    public CordovaExtWebView getView() {
//        return mWebView;
//    }
//
//    public int getstatus() {
//        return mStatus;
//    }
//
//    public void setCoocaaOSConnecter(CoocaaOSConnecter connecter) {
//        mWebView.setCoocaaOSConnecter(connecter);
//    }
//}
