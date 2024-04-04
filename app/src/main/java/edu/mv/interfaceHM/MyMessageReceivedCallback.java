package edu.mv.interfaceHM;

import static edu.mv.interfaceHM.NameSpace.SENDER_NAMESPACE;

import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;

public class MyMessageReceivedCallback implements Cast.MessageReceivedCallback {

    private TextView statusView;

    public MyMessageReceivedCallback(TextView statusView) {
        this.statusView = statusView;
    }

    @Override
    public void onMessageReceived(@NonNull CastDevice castDevice, @NonNull String namespace, @NonNull String message) {
        if (SENDER_NAMESPACE.equals(namespace)) {
            System.out.println("Bon namespace!");
        }
        statusView.setText(message);
    }
}

