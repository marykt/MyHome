package com.example.ubuntu.myhome;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;

//开机自启动广播接受
public class AutoStartBroadcastReceiver extends BroadcastReceiver {
    private static final String ACTION = "android.intent.action.BOOT_COMPLETED";
    private SharedPreferences mPreferences = null;

    @Override
    public void onReceive(Context context, Intent intent) {

        mPreferences = context.getSharedPreferences("AutoStart",
                ContextWrapper.MODE_PRIVATE);

        if (intent.getAction().equals(ACTION)) {

            if (mPreferences.getBoolean("AddToAuto", false)) {

                //后边的XXX.class就是要启动的服务
               Intent service = new Intent(context,AutoStartService.class);
                context.startService(service);

                // 启动应用，参数为需要自动启动的应用的包名，只是启动app的activity的包名
                Intent newIntent = context.getPackageManager()
                        .getLaunchIntentForPackage("com.example.autostart");
                context.startActivity(newIntent);
            }
        }
    }

}