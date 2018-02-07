package com.example.ubuntu.myhome;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

//开机自启动广播接受
public class AutoStartService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        Toast.makeText(this,"just test ",Toast.LENGTH_LONG).show();
        Log.d("TAG2","test service");
    }
}