package skyworth.cordova_skyworth_hybrid_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.skyworth.framework.skysdk.ipc.SkyActivity;
import com.tianci.system.api.TCSystemService;
import com.tianci.system.data.TCInfoSetData;
import com.tianci.system.data.TCSetData;
import com.tianci.system.define.TCEnvKey;

public class MainActivity extends SkyActivity {

    private static final String mTag = "WebViewSDK";
    private TCSystemService mSystemApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(mTag,"MainActivity onCreate");
    }

    @Override
    public void onCmdConnectorInit() {
        mSystemApi = new TCSystemService(this);
        TCSetData modelSetData = mSystemApi
                .getSetData(TCEnvKey.SKY_SYSTEM_ENV_MODEL);
        String modelString = "";
        if (modelSetData != null) {
            TCInfoSetData modelInfoData = (TCInfoSetData) modelSetData;
            modelString = modelInfoData.getCurrent();
        }
        Log.i(mTag,"MainActivity onCmdConnectorInit model = " + modelString);
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
