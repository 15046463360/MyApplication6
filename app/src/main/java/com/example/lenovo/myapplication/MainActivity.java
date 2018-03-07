package com.example.lenovo.myapplication;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SeekBar seek_Item;
    private Button kaishi;
    private Button zanting;
    private Button tingzhi;
    private Intent intent;
    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    private Button jiebang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        seek_Item = (SeekBar) findViewById(R.id.seek_Item);
        kaishi = (Button) findViewById(R.id.kaishi);
        zanting = (Button) findViewById(R.id.bangding);
        tingzhi = (Button) findViewById(R.id.tingzhi);

        kaishi.setOnClickListener(this);
        zanting.setOnClickListener(this);
        tingzhi.setOnClickListener(this);
        jiebang = (Button) findViewById(R.id.jiebang);
        jiebang.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        intent = new Intent(this, MyService.class);
        switch (v.getId()) {
            case R.id.kaishi:

                startService(intent);

                break;
            case R.id.bangding:
                bindService(intent, conn, Service.BIND_AUTO_CREATE);

                break;
            case R.id.tingzhi:
                stopService(intent);
                break;
            case R.id.jiebang:
                unbindService(conn);
                break;
        }
    }
}
