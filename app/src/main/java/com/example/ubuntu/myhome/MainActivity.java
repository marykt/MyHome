package com.example.ubuntu.myhome;



        import android.content.Intent;
        import android.os.Bundle;
        import android.app.Activity;
        import android.content.ContextWrapper;
        import android.content.SharedPreferences;
        import android.content.SharedPreferences.Editor;
        import android.view.Menu;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.TextView;

public class MainActivity extends Activity {

    private SharedPreferences mPreferences = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPreferences = getSharedPreferences("AutoStart",ContextWrapper.MODE_PRIVATE);
        boolean bStart = mPreferences.getBoolean("AddToAuto", false);

        final TextView textView1 = (TextView)findViewById(R.id.textView1);
        if (bStart) {
            textView1.setText("已打开开机自启动");
        }else {
            textView1.setText("已关闭开机自启动");
        }

        Editor editor = mPreferences.edit();
        editor.putBoolean("AddToAuto", true);
        editor.commit();
        textView1.setText("已打开开机自启动");
        //打开
        findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Editor editor = mPreferences.edit();
                editor.putBoolean("AddToAuto", true);
                editor.commit();
                textView1.setText("已打开开机自启动");

            }
        });

        //关闭
        findViewById(R.id.button2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Editor editor = mPreferences.edit();
                editor.putBoolean("AddToAuto", false);
                editor.commit();
                textView1.setText("已关闭开机自启动");

            }
        });

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }



}
