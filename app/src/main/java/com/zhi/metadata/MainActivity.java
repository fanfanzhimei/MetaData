package com.zhi.metadata;

import android.app.Activity;
import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            ActivityInfo activityInfo = getPackageManager().getActivityInfo(new ComponentName(this, MainActivity.class), PackageManager.GET_META_DATA);
            Bundle bundle = activityInfo.metaData;
            String name = bundle.getString("com.zhi.name");
            int age = bundle.getInt("com.zhi.age");
            int resourceid = bundle.getInt("com.zhi.resourceid");
            String log = "name:"+name+";age:"+age+";resourceid:"+resourceid;
            Toast.makeText(MainActivity.this, log, Toast.LENGTH_SHORT).show();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}