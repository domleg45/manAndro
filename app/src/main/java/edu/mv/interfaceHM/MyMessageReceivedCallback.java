package edu.mv.interfaceHM;

import static edu.mv.interfaceHM.NameSpace.SENDER_NAMESPACE;

import android.content.Intent;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;

public class MyMessageReceivedCallback implements Cast.MessageReceivedCallback {


    private MainActivity mainActivity;

    public MyMessageReceivedCallback(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onMessageReceived(@NonNull CastDevice castDevice, @NonNull String namespace, @NonNull String message) {
        if (SENDER_NAMESPACE.equals(namespace)) {
            Intent intent = new Intent(mainActivity, ExplosionActivity.class);
            mainActivity.startActivity(intent);
        }
    }
}

