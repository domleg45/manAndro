package edu.mv.interfaceHM;

import static edu.mv.interfaceHM.NameSpace.SENDER_NAMESPACE;

import androidx.annotation.NonNull;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.SessionManagerListener;

import java.io.IOException;

public class MySessionManagerListener implements SessionManagerListener<CastSession> {

    private CastSession currentCastSession;
    private Cast.MessageReceivedCallback msgCallback;

    public MySessionManagerListener(Cast.MessageReceivedCallback msgCallback) {
        this.msgCallback = msgCallback;
    }

    @Override
    public void onSessionStarting(CastSession session) {
        this.currentCastSession = session;
    }

    @Override
    public void onSessionSuspended(@NonNull CastSession castSession, int i) {

    }

    @Override
    public void onSessionStarted(CastSession session, String sessionId) {
        this.currentCastSession = session;

        try {
            System.out.println("Session Started! Tentative de message received callback");
            currentCastSession.setMessageReceivedCallbacks(SENDER_NAMESPACE, msgCallback);
        } catch (IOException e) {
            System.out.println("EXCEPTION - Tentative de message received callback");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onSessionEnded(@NonNull CastSession castSession, int i) {

    }

    @Override
    public void onSessionEnding(@NonNull CastSession castSession) {

    }

    @Override
    public void onSessionResumeFailed(@NonNull CastSession castSession, int i) {

    }

    @Override
    public void onSessionResumed(@NonNull CastSession castSession, boolean b) {

    }

    @Override
    public void onSessionResuming(@NonNull CastSession castSession, @NonNull String s) {

    }

    @Override
    public void onSessionStartFailed(CastSession session, int error) {
        // Appelé en cas d'échec de démarrage de la session
        // Vous pouvez gérer l'erreur ici
    }

    // Ajoutez d'autres méthodes d'écoute ici si nécessaire
}