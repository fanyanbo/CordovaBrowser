package skyworth.cordova_skyworth_hybrid_demo;

import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

import com.coocaa.x.xforothersdk.app.SuperXFinder;
import com.coocaa.x.xforothersdk.provider.db.table.download.TableDownload;
import com.skyworth.framework.skysdk.ipc.SkyApplication;
import com.skyworth.framework.skysdk.ipc.SkyCmdProcessInstance;
import com.skyworth.framework.skysdk.util.SkyJSONUtil;
import com.skyworth.ui.api.SkyWithBGLoadingView;
import com.skyworth.util.SkyScreenParams;
import com.tianci.system.api.TCSystemService;
import com.tianci.user.api.SkyUserApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by fanyanbo on 2018/6/5.
 * Email: fanyanbo@skyworth.com
 */

public class MainDialog extends Dialog {

    private static MainDialog instance = null;
    private FrameLayout mainLayout = null;
    private WebView mWebView = null;
    private Context mContext;
    private CoocaaCmdListener mCoocaaListener;
    private SkyWithBGLoadingView mLoadingView = null;
    private MyTableDownloadListener mDownloadListenrer;
    private MyTableMoniteDownloadListener mProcessListener;

    private final static String mTag = "TEST";

    @Override
    public boolean onKeyDown(int keyCode, @NonNull KeyEvent event) {
        Log.i(mTag,"onKeyDown keyCode = " + keyCode);
        return super.onKeyDown(keyCode, event);
    }

    public static MainDialog getInstance(Context context)
    {
        if (instance == null) {
            instance = new MainDialog(context);
        }
        return instance;
    }

    public MainDialog(@NonNull Context context) {
        super(context,R.style.dialog);

        mContext = context;

        mCoocaaListener = new CoocaaCmdListener();
        SkyCmdProcessInstance.getCmdProcessInstance(mContext, mCoocaaListener,
                null, SkyApplication.getProcessName(mContext, android.os.Process.myPid()));

        Window dialogWindow = getWindow();
        dialogWindow.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        dialogWindow.setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);

        mainLayout = new FrameLayout(context);

        mWebView = new WebView(context);
        mWebView.setBackgroundColor(0);
        mWebView.setVisibility(View.INVISIBLE);
        FrameLayout.LayoutParams webViewLp = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        mainLayout.addView(mWebView,webViewLp);

        mLoadingView = new SkyWithBGLoadingView(context);
        FrameLayout.LayoutParams loading_p = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,FrameLayout.LayoutParams.WRAP_CONTENT);
        loading_p.gravity = Gravity.CENTER;
        mLoadingView.setLayoutParams(loading_p);
        mainLayout.addView(mLoadingView);

        setContentView(mainLayout,new FrameLayout.LayoutParams(SkyScreenParams.getInstence(context).getResolutionValue(1920), SkyScreenParams.getInstence(context).getResolutionValue(1080)));

        initWebView();

        loadUrl();
    }

    private void initWebView() {

        WebSettings webSettings = mWebView.getSettings();

        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setAllowFileAccess(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setDefaultTextEncodingName("utf-8");

        mWebView.setInitialScale(0);
        mWebView.setVerticalScrollBarEnabled(false);
        mWebView.setHorizontalScrollBarEnabled(false);
        mWebView.setFocusable(false);

        mWebView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {

                Log.i(mTag,"onPageFinished url = " + url);
                // TODO Auto-generated method stub
                super.onPageFinished(view, url);

                mWebView.setVisibility(View.VISIBLE);

                if(mLoadingView != null)
                    mLoadingView.dismissLoading();
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

                Log.i(mTag,"onPageStarted url = " + url);
                // TODO Auto-generated method stub
                super.onPageStarted(view, url, favicon);


            }


        });

        mWebView.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onProgressChanged(WebView view, int newProgress) {

                Log.i(mTag,"onProgressChanged newProgress = " + newProgress);
            }

        });

        mWebView.addJavascriptInterface(new CoocaaApi(), "CoocaaApi");
    }

    public class CoocaaApi {

        @JavascriptInterface
        public String getUserInfo() {
            Log.i(mTag,"=====>getUserInfo");
            String ret = "";
            ret = mCoocaaListener.getLoginUserInfo();
            Log.i(mTag,"=====>getUserInfo = " + ret);
            return ret;
        }

        @JavascriptInterface
        public String download(final String value) {
            Log.i(mTag,"js download:" + value);
            try {
                if(mDownloadListenrer == null) {
                    SuperXFinder.setContext(mContext);
                    mDownloadListenrer = new MyTableDownloadListener();
                    TableDownload._createTableDownloadListener(mContext, mDownloadListenrer);
                    if(mProcessListener == null)
                    {
                        mProcessListener = new MyTableMoniteDownloadListener();
                        TableDownload._addTableDownloadMonitor(mProcessListener);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        JSONObject jsonParams = new JSONObject(value);
                        String url = jsonParams.getString("url");
                        String md5 = jsonParams.getString("md5");
                        String title = jsonParams.getString("title");
                        String pkgname = jsonParams.getString("pkg");
                        String appid = jsonParams.getString("appid");
                        String icon = jsonParams.getString("icon");
                        TableDownload checkdownloader = TableDownload._queryDownloadByUrl(url);
                        if (checkdownloader == null) {
                            checkdownloader = TableDownload._createAppDownload(url, md5, title, pkgname, appid, icon);
                        }
                        if (checkdownloader != null) {
                            if (mDownloadListenrer != null) {
                                mDownloadListenrer.addDownloadTask(checkdownloader);
                            }
                            TableDownload._start(checkdownloader.getId());
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            return "OK";
        }

        @JavascriptInterface
        public String getAppInfo(String value) {
            Log.i(mTag,"getAppInfo pkgName:" + value);
            PackageManager pm = mContext.getPackageManager();
            JSONObject valueObject = null;
            try {
                valueObject = new JSONObject();
                PackageInfo info = pm.getPackageInfo(value, 0);
                if (info != null) {
                    valueObject.put("status", "0");
                    valueObject.put("versionName", info.versionName);
                    valueObject.put("versionCode", info.versionCode);
                } else {
                    valueObject.put("status", "-1");
                    valueObject.put("versionName", "-1");
                    valueObject.put("versionCode", -1);
                }
                return valueObject.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "error";
        }
    }

    private void loadUrl() {
//        mWebView.loadUrl("http://beta.webapp.skysrt.com/games/test/test2.html");
        mWebView.loadUrl("http://beta.webapp.skysrt.com/games/dialog/index.html");
        if(mLoadingView != null)
            mLoadingView.showLoading();
    }

    private class CoocaaCmdListener implements SkyCmdProcessInstance.SkyCmdProcessInstanceListener
    {
        private TCSystemService systemApi;
        private SkyUserApi userApi;
        public CoocaaCmdListener()
        {
            systemApi = new TCSystemService(this);
            userApi = new SkyUserApi(this);
        }

        @Override
        public void onCmdConnectorInit() {
            Log.v(mTag,"CoocaaCmdListener received onCmdConnectorInit");
        }

        public String getLoginUserInfo()
        {
            if(userApi!=null)
            {
                Map<String, Object> userInfo= userApi.getAccoutInfo();
                if(userInfo!=null && userInfo.size()>0)
                {
                    return SkyJSONUtil.getInstance().compile(userInfo);
                }
            }
            return null;
        }

        @Override
        public byte[] onHandler(String fromtarget, String cmd, byte[] body) {

            return new byte[0];
        }

        @Override
        public void onResult(String fromtarget, String cmd, byte[] body) {

        }

        @Override
        public String getCmdClassName() {
            return mContext.getClass().getName();
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

    private class MyTableDownloadListener implements TableDownload.TableDownloadListener {
        private HashMap<Long, TableDownload> mTaskMaps = new HashMap<Long, TableDownload>();
        private final ReadWriteLock rwl = new ReentrantReadWriteLock();
        private final Lock readLock = rwl.readLock();
        private final Lock writeLock = rwl.writeLock();

        public MyTableDownloadListener() {
            super();
        }

        public boolean pauseTaskId(long taskID) {
            TableDownload loader = get(Long.valueOf(taskID));

            if (loader != null) {
                return loader._pause(taskID);
            }
            return false;
        }

        public boolean resumeTaskId(long taskID) {
            TableDownload loader = get(Long.valueOf(taskID));

            if (loader != null) {
                return loader._startNow(taskID);
            }
            return false;
        }

        public boolean deleteTaskId(long taskID) {
            TableDownload loader = get(Long.valueOf(taskID));

            if (loader != null) {
                return loader._remove(taskID);
            }
            return false;
        }

        public void addDownloadTask(TableDownload downloadTask) {
            put(downloadTask.getId(), downloadTask);
        }

        private TableDownload get(Long key) {
            readLock.lock();
            try {
                return mTaskMaps.get(key);
            } finally {
                readLock.unlock();
            }
        }

        private Long[] allKeys() {
            readLock.lock();
            try {
                return (Long[]) mTaskMaps.keySet().toArray();
            } finally {
                readLock.unlock();
            }
        }

        private TableDownload put(Long key, TableDownload value) {
            writeLock.lock();
            try {
                return mTaskMaps.put(key, value);
            } finally {
                writeLock.unlock();
            }
        }

        private void clear() {
            writeLock.lock();
            try {
                mTaskMaps.clear();
            } finally {
                writeLock.unlock();
            }
        }

        @Override
        public void onEnqueued(long id) {

        }

        @Override
        public void onStarting(long id, int code, String extra) {
//            JSONObject jsonObject = getCallBackJson(id,code,extra, TableDownload.DOWNLOAD_STATUS.ON_STARTING);
            String msg = "onStarting";
            mWebView.loadUrl("javascript:onDownloadingChanged('" + msg + "')");
        }

        @Override
        public void onStartDownloading(long id, int code, String extra) {
//            JSONObject jsonObject = getCallBackJson(id, code, extra, TableDownload.DOWNLOAD_STATUS.ON_DOWNLOADING);
            String msg = "onStartDownloading";
            mWebView.loadUrl("javascript:onDownloadingChanged('" + msg + "')");
        }

        @Override
        public void onPaused(long id, int code, String extra) {
//            JSONObject jsonObject = getCallBackJson(id, code, extra, TableDownload.DOWNLOAD_STATUS.ON_PAUSED);
            String msg = "onPaused";
            mWebView.loadUrl("javascript:onDownloadingChanged('" + msg + "')");
        }

        @Override
        public void onComplete(long id, int code, String extra) {
//            JSONObject jsonObject = getCallBackJson(id, code, extra, TableDownload.DOWNLOAD_STATUS.ON_COMPLETE);
            String msg = "onComplete";
            mWebView.loadUrl("javascript:onDownloadingChanged('" + msg + "')");
        }

        @Override
        public void onRemoved(long id, int code, String extra) {
//            JSONObject jsonObject = getCallBackJson(id, code, extra, TableDownload.DOWNLOAD_STATUS.ON_REMOVED);
            String msg = "onRemoved";
            mWebView.loadUrl("javascript:onDownloadingChanged('" + msg + "')");
        }

        @Override
        public void onStopped(long id, int code, String extra) {
//            JSONObject jsonObject = getCallBackJson(id, code, extra, TableDownload.DOWNLOAD_STATUS.ON_STOPPED);
            String msg = "onStopped";
            mWebView.loadUrl("javascript:onDownloadingChanged('" + msg + "')");
        }

        @Override
        public void onDownloading(TableDownload t) {
            if(t!=null)
            {
                put(Long.valueOf(t.getId()),t);
            }
            String msg = "onDownloading";
            mWebView.loadUrl("javascript:onDownloadingChanged('" + msg + "')");
        }

        public void onProcess(TableDownload t) {
            Log.i(mTag,"onProcess = " + t.getProgress());
            String msg = "onProcess";
            mWebView.loadUrl("javascript:onDownloadingChanged('" + msg + "')");
        }
    }

    private class MyTableMoniteDownloadListener implements TableDownload.TableDownloadMonitor
    {
        @Override
        public void onDownloading(TableDownload t) {
            if(mDownloadListenrer!=null)
            {
                mDownloadListenrer.onProcess(t);
            }
        }
    }
}
