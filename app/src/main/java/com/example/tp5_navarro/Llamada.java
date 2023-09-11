package com.example.tp5_navarro;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class Llamada extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getBooleanExtra("connected",true)){

            intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:"+"2664553747"));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
        else{
            Toast.makeText(context,"Wifi Apagado",Toast.LENGTH_LONG).show();
        }
    }
}
