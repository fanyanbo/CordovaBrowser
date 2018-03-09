package skyworth.cordova_skyworth_hybrid_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.skyworth.framework.skysdk.ipc.SkyActivity;
import com.tianci.system.api.TCSystemService;
import com.tianci.system.data.TCInfoSetData;
import com.tianci.system.data.TCSetData;
import com.tianci.system.define.TCEnvKey;

public class MainActivity extends SkyActivity {

    private static final String mTag = "WebViewSDK";
    private TCSystemService mSystemApi;
    private Button btn;
    private Button btn1;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_main);
        setContentView(R.layout.layout);
        Log.i(mTag,"MainActivity onCreate");

        editText = (EditText)findViewById(R.id.content_url);
        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String urlcontent = editText.getText().toString();
                Log.i(mTag,"onClick!!! url = " + urlcontent);
                if( urlcontent != null && ( urlcontent.startsWith("http://") || urlcontent.startsWith("https://")))
                {
                    Intent mIntent = new Intent("com.coocaa.webview.test");
                    mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mIntent.putExtra("url", urlcontent);
                    mIntent.putExtra("mode", 0);
                    startActivity(mIntent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "url is not illigel", Toast.LENGTH_LONG).show();
                }
            }
        });

        btn1 = (Button)findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String urlcontent = editText.getText().toString();
                Log.i(mTag,"onClick!!! url = " + urlcontent);
                if( urlcontent != null && ( urlcontent.startsWith("http://") || urlcontent.startsWith("https://")))
                {
                    Intent mIntent = new Intent("com.coocaa.webview.test");
                    mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mIntent.putExtra("url", urlcontent);
                    mIntent.putExtra("mode", 1);
                    startActivity(mIntent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "url is not illigel", Toast.LENGTH_LONG).show();
                }
            }
        });
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
