package skyworth.cordova_skyworth_hybrid_demo;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.widget.FrameLayout;

import com.skyworth.framework.skysdk.ipc.SkyActivity;
import com.skyworth.framework.skysdk.ipc.SkyApplication;
import com.skyworth.ui.api.SkyWithBGLoadingView;
import com.skyworth.util.SkyScreenParams;

import org.apache.cordova.CordovaExtWebView;
import org.coocaa.webview.CoocaaOSConnecterDefaultImpl;

import java.util.Map;

/**
 * Created by fanyanbo on 2018/4/9.
 * Email: fanyanbo@skyworth.com
 */

public class CordovaExtWebViewActivity extends SkyActivity {

    private String mDefaultUrl = "http://beta.webapp.skysrt.com/fyb/webapp/index.html";
    private FrameLayout mMainLayout = null;
    private SkyWithBGLoadingView mLoadingView = null;
    private CordovaExtWebView mCoocaaWebView = null;
    private SkyApplication.SkyCmdConnectorListener listener = null;
    private final static String mTag = "WebViewSDK";

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Log.i(mTag, "CordovaExtWebViewActivity onCreate threadId = " + android.os.Process.myTid());

        initUI();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) { //web页面加载后将接收不到事件回调

        Log.i(mTag, "onKeyDown keyCode = " + keyCode + ",event = " + event.getAction() + ",tid = " + android.os.Process.myTid());
        switch (event.getKeyCode()) {
            case KeyEvent.KEYCODE_1:
                mCoocaaWebView.loadUrl("http://beta.webapp.skysrt.com/appstore/webxtest/test7/test.html");
                break;
            case KeyEvent.KEYCODE_2:
                mCoocaaWebView.loadUrl("http://beta.webapp.skysrt.com/lxw/ceshi/nativeinfo2/index.html");
                break;
            case KeyEvent.KEYCODE_3:
                mCoocaaWebView.loadUrl("http://beta.webapp.skysrt.com/lxw/guide2/index.html");
                break;
            case KeyEvent.KEYCODE_4:
                mCoocaaWebView.loadUrl("http://beta.webapp.skysrt.com/lxw/ceshi/nfc2/index.html");
                break;
            case KeyEvent.KEYCODE_5:
                mCoocaaWebView.loadUrl("http://beta.webapp.skysrt.com/games/old/log/index.html ");
                break;
            case KeyEvent.KEYCODE_6:
                Log.i(mTag,"getStatus = " + mCoocaaWebView.getStatus());
                break;
            case KeyEvent.KEYCODE_7:
                Log.i(mTag,"getProgress = " + mCoocaaWebView.getPageLoadingProgress());
                break;
            case KeyEvent.KEYCODE_9:
                mCoocaaWebView.loadUrl(mDefaultUrl);
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {

        if (event.getAction() == 1) {
            Log.i(mTag, "dispatchKeyEvent keyCode = " + event.getKeyCode() + ",tid = " + android.os.Process.myTid());
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_1:
                    mCoocaaWebView.loadUrl("http://beta.webapp.skysrt.com/appstore/webxtest/test7/test.html");
                    break;
                case KeyEvent.KEYCODE_2:
                    mCoocaaWebView.loadUrl("http://beta.webapp.skysrt.com/lxw/ceshi/nativeinfo2/index.html");
                    break;
                case KeyEvent.KEYCODE_3:
                    mCoocaaWebView.loadUrl("http://beta.webapp.skysrt.com/lxw/guide2/index.html");
                    break;
                case KeyEvent.KEYCODE_4:
                    mCoocaaWebView.loadUrl("http://beta.webapp.skysrt.com/lxw/ceshi/nfc2/index.html");
                    break;
                case KeyEvent.KEYCODE_5:
                    mCoocaaWebView.loadUrl("http://beta.webapp.skysrt.com/games/old/log/index.html ");
                    break;
                case KeyEvent.KEYCODE_6:
                    Log.i(mTag,"getStatus = " + mCoocaaWebView.getStatus());
                    break;
                case KeyEvent.KEYCODE_7:
                    Log.i(mTag,"getProgress = " + mCoocaaWebView.getPageLoadingProgress());
                    break;
                case KeyEvent.KEYCODE_9:
                    mCoocaaWebView.loadUrl(mDefaultUrl);
                    break;
            }
        }
        return super.dispatchKeyEvent(event);
    }

    private void initUI() {

        Log.i(mTag,"CordovaExtWebViewActivity initUI threadId = " + android.os.Process.myTid());

        mMainLayout = new FrameLayout(this);

        mCoocaaWebView = new CordovaExtWebView(this);
        mCoocaaWebView.setBackgroundColor(Color.BLACK);
        FrameLayout.LayoutParams mWebViewLp = new FrameLayout.LayoutParams(SkyScreenParams.getInstence(this).getResolutionValue(1800), FrameLayout.LayoutParams.MATCH_PARENT);
        mWebViewLp.gravity = Gravity.CENTER_HORIZONTAL;
        if(listener != null)
            mCoocaaWebView.setCoocaaOSConnecter(new CoocaaOSConnecterDefaultImpl(listener));

        mCoocaaWebView.setCordovaExtWebViewListener(new CordovaExtWebView.CordovaExtWebViewListener() {

            @Override
            public void onPageStarted(String url) {
                Log.i(mTag,"mCoocaaWebView onPageStarted url = " + url);
            }

            @Override
            public void onPageFinished(String url) {
                Log.i(mTag,"mCoocaaWebView onPageFinished url = " + url);
            }

            @Override
            public void onPageError(int errorCode, String description, String failingUrl) {
                Log.i(mTag,"mCoocaaWebView onReceivedError url = " + failingUrl + ",description = " + description);
            }

            @Override
            public void onProgressChanged(int process) {
                Log.i(mTag,"mCoocaaWebView onProgressChanged process = " + process);
            }
        });

        mCoocaaWebView.setCordovaExtWebViewDataListener(new CordovaExtWebView.CordovaExtWebViewDataListener() {
            @Override
            public void notifyMessage(String data) {

            }

            @Override
            public void notifyLogInfo(String eventId, Map<String, String> map) {
                Log.i(mTag,"notifyLogInfo eventId = " + eventId);
                Log.i(mTag,"notifyLogInfo map = " + map);
            }

            @Override
            public void notifyPageResume(String pageName, Map<String, String> map) {

            }

            @Override
            public void notifyPagePause(String pageName) {

            }
        });
        mMainLayout.addView(mCoocaaWebView,mWebViewLp);

        mLoadingView = new SkyWithBGLoadingView(this);
        FrameLayout.LayoutParams loading_p = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,FrameLayout.LayoutParams.WRAP_CONTENT);
        loading_p.gravity = Gravity.CENTER;
        mLoadingView.setLayoutParams(loading_p);
        mLoadingView.setScaleW_H(SkyScreenParams.getInstence(this).getResolutionValue(120),SkyScreenParams.getInstence(this).getResolutionValue(120));
        mMainLayout.addView(mLoadingView);

        FrameLayout.LayoutParams mainLp = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        mMainLayout.setBackgroundColor(Color.DKGRAY);
        setContentView(mMainLayout,mainLp);
    }

    @Override
    protected void onPause() {
        super.onPause();

        if(mCoocaaWebView != null)
            mCoocaaWebView.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();

        if(mCoocaaWebView != null)
            mCoocaaWebView.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();

        if(mCoocaaWebView != null)
            mCoocaaWebView.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(mCoocaaWebView != null)
            mCoocaaWebView.onDestroy();
    }

    @Override
    public void onCmdConnectorInit() {

        Log.i(mTag,"CordovaExtWebViewActivity onCmdConnectorInit threadId = " + android.os.Process.myTid());
        listener = this;
    }

    @Override
    public byte[] onHandler(String fromtarget, String cmd, byte[] body) {
        return new byte[0];
    }

    @Override
    public void onResult(String fromtarget, String cmd, byte[] body) {

    }

    @Override
    public byte[] requestPause(String fromtarget, String cmd, byte[] body) {
        return new byte[0];
    }

    @Override
    public byte[] requestResume(String fromtarget, String cmd, byte[] body) {
        return new byte[0];
    }

    @Override
    public byte[] requestRelease(String fromtarget, String cmd, byte[] body) {
        return new byte[0];
    }

    @Override
    public byte[] requestStartToVisible(String fromtarget, String cmd, byte[] body) {
        return new byte[0];
    }

    @Override
    public byte[] requestStartToForground(String fromtarget, String cmd, byte[] body) {
        return new byte[0];
    }
}
