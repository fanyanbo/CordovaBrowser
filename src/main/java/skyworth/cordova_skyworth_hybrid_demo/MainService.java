//package skyworth.cordova_skyworth_hybrid_demo;
//
//import android.app.Service;
//import android.content.Intent;
//import android.os.IBinder;
//import android.support.annotation.IntDef;
//import android.support.annotation.Nullable;
//import android.util.Log;
//
//import com.skyworth.framework.skysdk.ipc.SkyApplication;
//import com.skyworth.framework.skysdk.ipc.SkyService;
//
//import org.coocaa.webview.CoocaaOSConnecter;
//import org.coocaa.webview.CoocaaOSConnecterDefaultImpl;
//
///**
// * Created by fanyanbo on 2018/6/5.
// * Email: fanyanbo@skyworth.com
// */
//
//public class MainService extends SkyService {
//
//    protected static SkyApplication.SkyCmdConnectorListener listener;
//    private static final String mTag = "WebViewSDK";
//    private CordovaWebViewSingleton mCordovaWebView;
//    private CoocaaOSConnecter mCoocaaOSConnecter;
//
//    private boolean isFirst = false;
////    private String mDefaultUrl = "http://beta.webapp.skysrt.com/fyb/webapp/index.html";
////    private String mDefaultUrl = "http://beta.webapp.skysrt.com/games/voice/index.html";
////      private String mDefaultUrl = "http://beta.webapp.skysrt.com/appstore/webxtest/test7/test.html";
////     private String mDefaultUrl = "http://beta.webapp.skysrt.com/fyb/screensaver/index.html";
////    private String mDefaultUrl = "http://beta.webapp.skysrt.com/games/fis/index.html";
//    private String mDefaultUrl = "https://webapp.skysrt.com/boot/qcode/index.html";
//
//    @Override
//    public void onCreate() {
//        // TODO Auto-generated method stub
//        super.onCreate();
//
//        isFirst = true;
//
//        Log.i(mTag, "MainService->onCreate");
//    }
//
//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//        Log.i(mTag, "==============>MainService->onStartCommand isFirst = " + isFirst);
//        Log.i(mTag, "MainService->onStartCommand url = " + intent.getStringExtra("url"));
//        if(isFirst) {
//            isFirst = false;
//        }else{
//            mCordovaWebView.loadUrl(intent.getStringExtra("url"));
//        }
//
//        return super.onStartCommand(intent, flags, startId);
//    }
//
//    @Override
//    public void onCmdConnectorInit() {
//        Log.i(mTag, "==============>MainService->onCmdConnectorInit");
//        mCoocaaOSConnecter = new CoocaaOSConnecterDefaultImpl(getApplicationContext(),this);
//        mCordovaWebView = CordovaWebViewSingleton.getInstance(getApplicationContext());
//        mCordovaWebView.setCoocaaOSConnecter(mCoocaaOSConnecter);
//        mCordovaWebView.loadUrl(mDefaultUrl);
//    }
//
//    @Nullable
//    @Override
//    public IBinder onBind(Intent intent) {
//        return null;
//    }
//
//    @Override
//    public byte[] onHandler(String fromtarget, String cmd, byte[] body) {
//        Log.i(mTag,"MainService onHandler fromtarget = " + fromtarget + ",cmd = " + cmd);
//        Log.i(mTag,"MainService onHandler mCordovaWebView isShown() = " + mCordovaWebView.getView().isShown());
//        return mCoocaaOSConnecter.onHandler(getApplicationContext(),fromtarget,cmd,body);
//    }
//
//    @Override
//    public void onResult(String fromtarget, String cmd, byte[] body) {
//
//    }
//
//    @Override
//    public byte[] requestPause(String fromtarget, String cmd, byte[] body) {
//        return new byte[0];
//    }
//
//    @Override
//    public byte[] requestResume(String fromtarget, String cmd, byte[] body) {
//        return new byte[0];
//    }
//
//    @Override
//    public byte[] requestRelease(String fromtarget, String cmd, byte[] body) {
//        return new byte[0];
//    }
//
//    @Override
//    public byte[] requestStartToVisible(String fromtarget, String cmd, byte[] body) {
//        return new byte[0];
//    }
//
//    @Override
//    public byte[] requestStartToForground(String fromtarget, String cmd, byte[] body) {
//        return new byte[0];
//    }
//}
