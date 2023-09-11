package com.example.tp5_navarro;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Llamada la;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LlamadaBrodcast();
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M
                && checkSelfPermission(Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE},2500);
        }
    }

    private void LlamadaBrodcast() {
        this.la =new Llamada();
        registerReceiver(this.la , new IntentFilter("android.net.wifi.supplicant.CONNECTION_CHANGE"));

    }
    protected void OnDestroy(){
        super.onDestroy();
        unregisterReceiver(this.la);
    }
}